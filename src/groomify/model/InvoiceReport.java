/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

import groomify.db.DBConnection;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Chirath
 */
public class InvoiceReport {
    private Connection connection;
    
    public InvoiceReport(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public void generateInvoice(int invoiceId){
        try{
            JasperReport report = (JasperReport) JRLoader.loadObject(
                InvoiceReport.class.getResourceAsStream(
                    "/reports/GroomifyInvoice.jasper"
                )
            );

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("invoiceId", invoiceId);

            JasperPrint print = JasperFillManager.fillReport(
                report,
                parameters,
                connection
            );

            JasperViewer.viewReport(print, false);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
