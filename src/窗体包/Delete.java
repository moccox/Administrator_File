/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 窗体包;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class Delete extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    DefaultTableModel tableModel=new DefaultTableModel();
    JPanel jp=new JPanel();
    JTable table=new JTable(tableModel);
    JScrollPane tableScrollPane=new JScrollPane(table);
    JButton jb1=new JButton();
    JButton jb2=new JButton();
    JTextField t1=new JTextField(3);
    JLabel l1=new JLabel("您打算删除第");
    JLabel l2=new JLabel("行内容");
    /**
     * Creates new form Delete
     */
    public Delete() throws FileNotFoundException, IOException {
        while(tableModel.getRowCount()>0) { /*清空表格内容*/
            tableModel.removeRow(tableModel.getRowCount()-1);
        }
        tableModel.addColumn("姓名");
        tableModel.addColumn("购买商品");
        tableModel.addColumn("商品价格");
        tableModel.addColumn("购买日期");
        jp.setLayout(null);
        this.setSize(400, 400);
        /*页面布局*/
        tableScrollPane.setBounds(0,10,400,300);
        l1.setBounds(10, 320, 80, 30);
        t1.setBounds(85, 320, 35, 30);
        l2.setBounds(125, 320, 45, 30);
        jb1.setBounds(197, 320, 60, 30);
        jb2.setBounds(284, 320, 60, 30);
        jb1.setText("确定");
        jb1.addActionListener(new ActionListener(){ /*按钮1事件【删除某行并写入文件】*/
             public void actionPerformed(ActionEvent e){
                     String s=t1.getText();
                     int num=Integer.parseInt(s);
                     if(num>tableModel.getRowCount() || num<0){
                         System.out.println("找不到该行内容！");
                     }else{
                         tableModel.removeRow(num-1); //删除该行 因为行是从0开始的，所以是num-1
                         String[] str=new String[tableModel.getRowCount()];
                         int i,j;
                         for(i=0;i<tableModel.getRowCount();i++){
                           String a=(String) table.getValueAt(i, 0);
                           str[i]=a+",";
                         }
                          /*
                           先读取第一列的内容将null变成第一列内容
                           后面从此基础上从第二列开始读起
                           避免第一列变成【null姓名】的情况
                          */
                         for(i=0;i<tableModel.getRowCount();i++){
                            for(j=1;j<tableModel.getColumnCount()-1;j++){
                                   String a=(String) table.getValueAt(i,j);
                                   str[i]=str[i]+a+","; //最后一列不读 因为不能加【,】
                            }
                             str[i]=str[i]+table.getValueAt(i,j)+'\n'; //读取最后一列并加【\n】
                         }
                         try{
                               File f=new File("Consumer.txt");
                               if(!f.exists()) throw new FileNotFoundException();
                               FileWriter FW=new FileWriter(f.getAbsolutePath(),false);
                                for(i=0;i<tableModel.getRowCount();i++){
                                    FW.write(str[i]);
                                }
                               FW.close();
                         }catch(FileNotFoundException ex){
                                 System.out.println("找不到文件");
                         } catch (IOException ex) {
                                 Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
                         }catch(Exception ex){
                                 System.out.println("未知的错误");
                         }
                     }
             }
        });
        jb2.setText("返回");
        jb2.addActionListener(new ActionListener(){ /*按钮2事件【返回到主界面】*/
            public void actionPerformed(ActionEvent e){
                  dispose();
                  MainReal a=new MainReal();
                  a.setVisible(true);
            }
        });
        /*添加挂件*/
        jp.add(tableScrollPane);
        jp.add(l1);
        jp.add(t1);
        jp.add(l2);
        jp.add(jb1);
        jp.add(jb2);
        
        this.add(jp);
        this.setResizable(false);
        this.setVisible(true);
        /*文件数据写入表格*/
        try{
          File f=new File("Consumer.txt");
          if(!f.exists()) throw new FielNotFoundException();
          FileReader FR=new FileReader (f.getAbsolutePath());
          BufferedReader  BR=new BufferedReader(FR);
          
          String str=null;
          while((str=BR.readLine())!=null){
              String []s=str.split(",");
              tableModel.addRow(s);
          }
          BR.close();
          FR.close();
         }catch(FielNotFoundException ex){
             System.out.println("找不到文件");
         }       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Delete().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private static class FielNotFoundException extends Exception {

        public FielNotFoundException() {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
