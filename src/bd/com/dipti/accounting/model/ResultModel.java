/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.com.dipti.accounting.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author tahmi
 */
public class ResultModel extends AbstractTableModel{
    
    public void setResultSet(ResultSet results){
        
        if(results==null){
            columnNames = new String[0];
            dataRows.clear();
            fireTableChanged(null);
            return;
        }
        
        try{
            ResultSetMetaData metadata = results.getMetaData();
            int columns = metadata.getColumnCount();
            columnNames = new String[columns];
            
            for (int i = 0; i < columns; i++) {
                columnNames[i] = metadata.getColumnLabel(i+1);
                if(columnNames[i] != null){
                    columnNames[i].trim();
                }
            }
            dataRows.clear();
            String[] rowsData =null;
            while(results.next()){
                rowsData = new String[columns];
                
                for (int i = 0; i < 10; i++) {
                    rowsData[i] = results.getString(i+1);
                    if(rowsData[i] != null){
                        rowsData[i].trim();
                    }
                }
                dataRows.addElement(rowsData);
            }
            fireTableChanged(null);
        } catch(SQLException sqle){
            System.out.println(sqle);
        }
    }
    @Override
    public int getRowCount() {
       if(dataRows == null){
           return 0;
       }
       else{
           return dataRows.size();
       }
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return dataRows.elementAt(row)[column];
    }
    
    public String getColumnNames(int column){
        return columnNames[column] == null?"No Name" : columnNames[column];
    }
    
    public Class getColumnClass(int column){
    return String.class;
    }
    
    private String[] columnNames = new String[0];
    private Vector<String[]> dataRows = new Vector<String[]>();
    String maxColumnCell = null;
    
   
    
}
