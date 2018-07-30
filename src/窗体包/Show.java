/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 窗体包;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.JButton;
/**
 *
 * @author Administrator
 */
public class Show extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    DefaultTableModel tableModel=new DefaultTableModel();



    
public Show() {
        while(tableModel.getRowCount()>0) { /*清空表格内容*/
            tableModel.removeRow(tableModel.getRowCount()-1);
        }
        JPanel jp=new JPanel();
        JTable table=new JTable(tableModel);
        JScrollPane tableScrollPane=new JScrollPane(table);
        JButton jb=new JButton();
        tableModel.addColumn("姓名");
        tableModel.addColumn("购买商品");
        tableModel.addColumn("商品价格");
        tableModel.addColumn("购买日期");
        jp.setLayout(null);
        tableScrollPane.setBounds(0,40,400,360);
        jp.add(tableScrollPane);
        jb.setText("返回");
        jp.add(jb);
        jb.setSize(70, 40);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                      dispose();
                      MainReal a=new MainReal();
                      a.setVisible(true);
            }
        });
        this.setSize(400,400);
        this.add(jp);
        this.setResizable(false);
        this.setVisible(true);
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
         }catch(Exception ex){
              System.out.println("未知的错误");
         }

    }


    private static class FielNotFoundException extends Exception{

        public FielNotFoundException() {
            super();
        }
    }
}

/*
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

*/