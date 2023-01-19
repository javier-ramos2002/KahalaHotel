package Class;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Instant;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;





public class Recibo {
    static int codigo;
    
    
    public static void main(String[] args) {
        new Recibo();
    }
    
    
    /**
     * Metodo que crea un documento 'Recibo' de la reserva de un cliente en formato PDF.
     * @param c Cliente que posee la reserva (object)
     * @param r La reserva en cuestion (object)
     * @param Doc
     */
    public static void  crearRecibo (Cliente c, ReservaTabla rt, Document Doc) {
        
        try {
            //int codigo = r.getCod();
            // Crea un writer para escribir en el documento
            PdfWriter.getInstance(Doc, new FileOutputStream("Recibo_"+ codigo++ +"_"+ obtenerFecha()+".pdf"));

            // Abre el documento
            Doc.open();

           
            
           
            Doc.add(new Paragraph("Recibo"));
            Doc.add(new Paragraph("Fecha: " + obtenerFecha()));
            Doc.add(new Paragraph("Cliente: " + c.getNombre()));
            Doc.add(new Paragraph("Apellido: " + c.getApellido()));
            Doc.add(new Paragraph("DNI: " + c.getDni()));
            Doc.add(new Paragraph("Fecha Nacimiento: " + c.getFechaNacimiento()));
            
            
          
            
            
            Doc.add(new Paragraph("Fecha de inicio: " + rt.getFechaInicio()));
            Doc.add(new Paragraph("Fecha de fin: " + rt.getFechaFin()));
            Doc.add(new Paragraph("Monto: $" + rt.getNumPersonas()));

            // Cierra el documento
            Doc.close();
          } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
          }
        }

    /**
     * Metodo que devuelve la fecha acual del sistema en segundos
     * @return
     */
    private static String obtenerFecha() {
     
        Instant instant = Instant.now();
        long timeInSeconds = instant.getEpochSecond();
        return String.valueOf(timeInSeconds);
      }

    
    
    
    /**
     * Metodo que dependiendo si el usuario selecciona la 
     * @param c El cliente que ha realizado la resrva (object)
     * @param r La reserva en cuestion (object)
     * @throws MessagingException 
     */
    public static void guardardPDF (Cliente c, ReservaTabla r) throws FileNotFoundException, DocumentException, MessagingException {
        
        String[] opciones = new String[] {"Descargar en PDF", "Enviar por correo"};
        int resp = JOptionPane.showOptionDialog(null, "Selecciona la forma en la que quieres recibir el recibo", "Opciones recibo", 
          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        
        if (resp == 0 ) {
            
            JFileChooser jfc = new JFileChooser();
            int resul = jfc.showSaveDialog(null);
            
            if (resul == JFileChooser.APPROVE_OPTION) {
                
               String direc = jfc.getSelectedFile().getPath();
               FileOutputStream reci = new FileOutputStream(direc+ ".pdf");
               Document doc = new Document();
               PdfWriter.getInstance(doc, reci);
               crearRecibo(c, r, doc);
            }
            
            else {
                
                Document doc = new Document();
                String nombre = "Reserva"+r.getCod()+".pdf";
                String comp = "C:/Users/JavierNavaridas/Desktop/UNI/5 semestre/Programacion 3/PROYECTO/Pdf/"+nombre;
                FileOutputStream reci = new FileOutputStream(comp);                
                PdfWriter.getInstance(doc, reci);
                crearRecibo(c, r, doc);
                generaEMAIL(comp, nombre);
                
            }
              
        }
       
            
        
    }
    /**
     * Metodo que genera un Email y lo envia a la direccion de correo pedida
     * @param dir direccion del archivo que se envia
     * @param nom nombre del archivo que se envia
     * @throws MessagingException 
     */
    public static void generaEMAIL (String dir, String nom) throws MessagingException {
        String correo="";
        String contra="";
        
        
        String correoDestinatario=JOptionPane.showInputDialog(null,"Introduzca su correo completo por favor");
        
        Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            
            p.setProperty("mail.smtp.user", correo);
            p.setProperty("mail.smtp.auth", "true");
            
        Session s = Session.getDefaultInstance(p);
        BodyPart texto = new MimeBodyPart();
            texto.setText("Aqui se encuentra adjuntado el recibo de su reserba. Esperamos que su estancia haya sido gratificante" );
                   
        
        BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(dir)));
            adjunto.setFileName(nom);
            
        MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            m.addBodyPart(adjunto);
        
            
        
        MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
            mensaje.setSubject("Recio Reserva ");
            mensaje.setContent(m);

            
        Transport t = s.getTransport("smtp");
        t.connect(correo, contra);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        
        
        
        t.close();
        
        JOptionPane.showMessageDialog(null, "envio del mensaje realizado","Mensaje Enviado",JOptionPane.INFORMATION_MESSAGE);
        
         
        
     
    }

}
