package com.farmsystem.backend.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.BuyerCart;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;
import com.farmsystem.backend.repository.BuyerCartRepo;
import com.farmsystem.backend.repository.BuyerRepo;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@CrossOrigin
@RestController
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	BuyerRepo buyerRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	BuyerCartRepo buyercartRepo;
	
	@Autowired
	FarmerRepo farmerRepo;
	
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Buyer buyer) {
	        
			System.out.println(buyer.getPassword());
			System.out.println(buyer.getUser_name());
			List<Buyer> buyerList = buyerRepo.findAll();              
			
			String passMsg = "pass" ;
			String failMsg = "fail" ;
			
			for(Buyer buyerobj : buyerList )
			{
			if(buyerobj.getUser_name().equals(buyer.getUser_name()) && buyerobj.getPassword().equals(buyer.getPassword()))
				{
					
					return passMsg ;
				}
			}
		
		return failMsg;
	}
	
	@PostMapping("/Registration")
	public String regFarmer(@RequestBody Buyer buyer) {

		     
		    buyerRepo.save(buyer);
		     
		    return "register_success";
		    
	}
	
	@PostMapping("/search")
	public List<Product> searchProduct(@RequestBody Product prod) {
	        
			String item = prod.getCrop();
			List<Product> productList = productRepo.findProduct(item);              
		
		return productList;
	}
	
	@PostMapping("/allsearch")
	public List<Product> searchProduct() {
	        
			
			List<Product> productList = productRepo.findAll();              
		
		return productList;
	}
	
	
	@PostMapping("/myCart")
	public List<BuyerCart> buyerCart() {
	        
			
		List<BuyerCart> cartlist = buyercartRepo.findAll();              
		
		return cartlist;
	}
	
	//http://localhost:9099/buyer/confirmed-orders
		
		@PostMapping("/confirmed-orders")
	public List<Order> buyerCart(@RequestBody Buyer buyer) {
	        
			System.out.println(buyer.getUser_name());
			String uname = buyer.getUser_name();
			
			int bid = buyerRepo.findByName(uname);
			
			List<Order> orderList = orderRepo.findByBId(bid);  
			
			return orderList;
		
	}
		
		@PostMapping("/addOrder")
		public String regFarmer(@RequestBody Order order) {
				
			String buyeruname = order.getBuyer().getUser_name();
			
			System.out.println(buyeruname);
			int bid = buyerRepo.findByName(buyeruname);
				order.getBuyer().setBid(bid);
				
				String farmername = order.getFarmer().getFirstname();
				System.out.println(farmername);
				int fid = farmerRepo.findByFid(farmername);
				order.getFarmer().setFid(fid);
			    orderRepo.save(order);
			     
			    return "added";
			    
		}
		
		@GetMapping("/profile/{username}")
		public Optional<Buyer> getBuyer(@PathVariable String username) {

			
			int bid = buyerRepo.findByName(username);
				          
			return buyerRepo.findById(bid);
			    
		}
		
		@GetMapping("/remove/{username}")
		public String removeFarmer(@PathVariable String username) {

			
			try {
				int bid = buyerRepo.findByName(username);
				buyerRepo.deleteById(bid);
				return "updated";
			} catch (Exception e) {
				return "fails";
			}
			    
		}
		
		
		
		 public static void export(HttpServletResponse response) throws IOException {
		        Document document = new Document(PageSize.A4);
		        PdfWriter.getInstance(document, response.getOutputStream());

		        document.open();
		        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		        fontTitle.setSize(18);

		        Paragraph paragraph = new Paragraph("kisanSEVA Payment Receipt", fontTitle);
		        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
		        fontParagraph.setSize(12);
		        	
		        String content = "Order Number :                             11231"
		        		+ "\nAddress                                    Hingoli"
		        		+ "\nDate :                                     12/12/2022"
		        		+ "\n======================================================"
		        		+ "\n   Menu                  Price             Quantity"
		        		+ "\n======================================================"
		        		+ "\n                              "
		        		+ "\n Wheet                   20000               10            "
		        		+ "\n......................................................."
		        		+ "\nTotal Paid                                  200000";
		        Paragraph paragraph2 = new Paragraph(content, fontParagraph);
		       
		        
		        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

		        document.add(paragraph);
		        document.add(paragraph2);
		        document.close();
	 }
		
		 @GetMapping("/pdf/generate")
		    public String generatePDF(HttpServletResponse response) throws IOException {
		        response.setContentType("application/pdf");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());

		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment";
		        String filename="kisanSEVA" + currentDateTime + ".pdf";
		       // response.setHeader(headerKey, headerValue);
		        Document document = new Document(PageSize.A4);
		        PdfWriter.getInstance(document, response.getOutputStream());

		        document.open();
		        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		        fontTitle.setSize(18);

		        Paragraph paragraph = new Paragraph("kisanSEVA Payment Receipt", fontTitle);
		        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
		        fontParagraph.setSize(12);
		        	
		        String content = "Order Number :                             11231"
		        		+ "\nAddress                                    Hingoli"
		        		+ "\nDate :                                     12/12/2022"
		        		+ "\n======================================================"
		        		+ "\n   Menu                  Price             Quantity"
		        		+ "\n======================================================"
		        		+ "\n                              "
		        		+ "\n Wheet                   20000               10            "
		        		+ "\n......................................................."
		        		+ "\nTotal Paid                                  200000";
		        Paragraph paragraph2 = new Paragraph(content, fontParagraph);
		       
		        
		        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

		        document.add(paragraph);
		        document.add(paragraph2);
		        document.close();
//		        export(response);
		        
		        String message = "Hello , Dear, this is message for security check . ";
				String subject = "kisanSEVA";
				String to = "adit.patange@gmail.com";
				String from = "adit.patange@gmail.com";
			    
			  //Variable for gmail
				String host="smtp.gmail.com";
			
			//get the system properties
			Properties properties = System.getProperties();
			System.out.println("PROPERTIES "+properties);
			
			//setting important information to properties object
			
			//host set
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port","465");
			properties.put("mail.smtp.ssl.enable","true");
			properties.put("mail.smtp.auth","true");
			
			//Step 1: to get the session object..
			Session session=Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {				
					return new PasswordAuthentication("adit.patange@gmail.com", "9970120412#");
				}
				
				
				
			});
			
			session.setDebug(true);
			
			//Step 2 : compose the message [text,multi media]
			MimeMessage m = new MimeMessage(session);
			
			try {
			
			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
		
			
			//attachement..
			
			//file path
			String path="C:\\Users\\HP\\Desktop\\generate.pdf";
			
//			file:///C:/Users/HP/Desktop/generate.pdf
			MimeMultipart mimeMultipart = new MimeMultipart();
			//text
			//file
			
			MimeBodyPart textMime = new MimeBodyPart();
			
			MimeBodyPart fileMime = new MimeBodyPart();
			
			try {
				
				textMime.setText(message);
				
				File file=new File(path);
				fileMime.attachFile(file);
				
				
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
			
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			m.setContent(mimeMultipart);
			
			
			//send 
			
			//Step 3 : send the message using Transport class
			Transport.send(m);
	
			System.out.println("Sent success...................");
									
				}catch (Exception e) {
				e.printStackTrace();
			}
		        
		        
		        return "done";
		    }
		
}
