import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.net.ssl.*;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
//import com.sun.org.apache.xml.internal.security.utils.Base64;

public class SAAJPayload {



public static void main(String[] args) throws Exception
{
    //try {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapmsg = factory.createMessage();
        SOAPPart soapPart = soapmsg.getSOAPPart();

            String authorization = "Enter the Base64 converted username password";
            MimeHeaders hd = soapmsg.getMimeHeaders();
            hd.addHeader("Authorization", "Basic " + authorization);

        String myNamespaceURI = "http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/";
        String myNamespace = "typ";
        String myNamespaceURI1 = "http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/";
        String myNamespace1 = "erp";
        String destination = "<Enter Cloud url>/publicFinancialCommonErpIntegration/ErpIntegrationService";



        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        envelope.addNamespaceDeclaration(myNamespace1, myNamespaceURI1);
        System.out.println("\n");
        SOAPHeader header = envelope.getHeader();
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("uploadFileToUcm", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("document", myNamespace);
        SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("Content", myNamespace1);
        soapBodyElem2.addTextNode("UEsDBBQAAAAIAASmL0sJI7gtswAAAEgCAAAPAAAAR2xJbnRlcmZhY2UuY3N2vZBRC4IwFIXfg/7DfsBq905pvioaGDajgp6HCQoxQ+f/T3NSCYEP0Xm43LNzB4dPRhfqwCBHcAdRUA7oMuAMXZqaIq/tjOWxjwQDwbhH/d4A0OdX2m2ICNzaYX5Vd70e8r3SrbqRQJmsIKfUPyDQc94YsqvaWo/JyiafkX0c7TYIY5JU6tp17ZWUOidh3mR1eTdlpXFSgnsokCOflntXJMPlQv6W0WYeoxekPzKawpjN6AFQSwECFAAUAAAACAAEpi9LCSO4LbMAAABIAgAADwAAAAAAAAABACAAAAAAAAAAR2xJbnRlcmZhY2UuY3N2UEsFBgAAAAABAAEAPQAAAOAAAAAAAA==");
        SOAPElement soapBodyElem3 = soapBodyElem1.addChildElement("FileName", myNamespace1);
        soapBodyElem3.addTextNode("GlInterface.zip");
        SOAPElement soapBodyElem4 = soapBodyElem1.addChildElement("ContentType", myNamespace1);
        soapBodyElem4.addTextNode("zip");
        SOAPElement soapBodyElem5 = soapBodyElem1.addChildElement("DocumentTitle", myNamespace1);
        soapBodyElem5.addTextNode("SAAJ Test");
        SOAPElement soapBodyElem6 = soapBodyElem1.addChildElement("DocumentAuthor", myNamespace1);
        soapBodyElem6.addTextNode("Auto Upload");
        SOAPElement soapBodyElem7 = soapBodyElem1.addChildElement("DocumentSecurityGroup", myNamespace1);
        soapBodyElem7.addTextNode("FAFusionImportExport");
        SOAPElement soapBodyElem8 = soapBodyElem1.addChildElement("DocumentAccount", myNamespace1);
        soapBodyElem8.addTextNode("fin$/generalLedger$/import$");
        SOAPElement soapBodyElem9 = soapBodyElem1.addChildElement("DocumentName", myNamespace1);
        soapBodyElem9.addTextNode("6129889453");
        SOAPElement soapBodyElem10 = soapBodyElem1.addChildElement("DocumentId", myNamespace1);
        soapBodyElem10.addTextNode("#NULL");

        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(soapmsg,destination);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }


        // https://www.coderanch.com/wiki/659769/Web-Services
        // working code



}
