package pl.winiarek.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.winiarek.entity.Counter;
import pl.winiarek.service.CounterService;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class CounterReport {

    @Autowired
    private CounterService counterService;

    public void generateReport() throws JRException, IOException {
        List<Counter> tempCounter = counterService.getWaterCounter();
        for (Counter temp : tempCounter
        ) {
            System.out.println("\nSerial number : " + temp.getCounterSerialNumber());

        }
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(tempCounter);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String outputFile = "src/main/webapp/WEB-INF/downloads/pdf/" + "RaportLiczniki_" + formatter.format(calendar.getTime()) + ".pdf";
        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        BufferedImage image = ImageIO.read(new File("src/main/java/JasperReport/images/sauter_logo.jpeg"));
        parameters.put("SauterLogo", image);
        image = ImageIO.read(new File("src/main/java/JasperReport/images/wolapark_logo.png"));
        parameters.put("WolaLogo", image);
        parameters.put("CountersBeanParam", itemsJRBean);

        //read jrxml file and creating jasperdesign object
        InputStream input = new FileInputStream(new File("src/main/java/JasperReport/reports/Report_all.jrxml"));

        JasperDesign jasperDesign = JRXmlLoader.load(input);

        /*compiling jrxml with help of JasperReport class*/
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        /* Using jasperReport object to generate PDF */
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        /*call jasper engine to display report in jasperviewer window*/
        //JasperViewer.viewReport(jasperPrint);


        /* outputStream to create PDF */
        OutputStream outputStream = new FileOutputStream(new File(outputFile));


        /* Write content to PDF file */
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        System.out.println("File Generated");
       // List<String> results = new ArrayList<String>();
        System.out.println("Lista plików : ");


    }


}
