package kati1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

import java.awt.*;
public class DbApp {
	Connection conn;

	public DbApp() {
		conn = null;
	}
	
	public void connect (/*String database, String username, String password*/) {
		try {
     		Class.forName("org.postgresql.Driver");
     		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db130516new", "postgres", "boss");
     		System.out.println("Connection Established!");
     		// STEP 4 ----->
     		conn.setAutoCommit(true);
     		// STEP 4 <-----
     		
		} catch(Exception e) {
            e.printStackTrace();
		}
	}
	
	// STEP 4 ----->
/*	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

/*	public void printMembers() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from member");
			
			while (rs.next()) {
				System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/

	public int getRandInt(int s) {
		return ( (int) ( Math.random() * s) );	
	}
	
	
	public void insertArticles() {
		int randmember;
		Random r=new Random();
		int [] dateOfMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		int [] dateOfMonth2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int [] dateOfMonth3 = { 2010,2011,2012,2013,2014,2015};
		int [] dateOfMonth4 = { 1,2,3,4};
		try {
		//	PreparedStatement pst2 = conn.prepareStatement("insert into public.article (articleid) values (45)"); //,\"arthro10\",3,\"kati2\",\"2014-10-23\",\"member2@network2.com\
		//	pst2.execute();
			PreparedStatement pst = conn.prepareStatement("insert into article values (?,?,?,?,?,?)");
			
			for (int i=0;i<15000;i++) {
				pst.setInt(1, (i+18));
				pst.setString(2, "arthro"+(i+9));
				pst.setInt(3, dateOfMonth4[getRandInt(dateOfMonth4.length)]);
				pst.setString(4, "kati"+i);
				String dateOfBirth = Integer.toString(dateOfMonth3[getRandInt(dateOfMonth3.length)]);
				String dateOfBirth2 = Integer.toString(dateOfMonth2[getRandInt(dateOfMonth2.length)]);
				String dateOfBirth3 = Integer.toString(dateOfMonth[getRandInt(dateOfMonth.length)]);
				String imer = dateOfBirth+"-"+dateOfBirth2+"-"+dateOfBirth3;
				pst.setDate(5, java.sql.Date.valueOf(imer));
				randmember=1000+r.nextInt(10000-1000+1);
				pst.setString(6, "member"+randmember+"@network"+randmember+".com");
				pst.execute();
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void insertArticleComments() {
		int randmember;
		Random r=new Random();
		int [] dateOfMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		int [] dateOfMonth2 = { 1, 2, 3, 4};
		int [] dateOfMonth3 = {2016};
		try {
		//	PreparedStatement pst2 = conn.prepareStatement("insert into public.article (articleid) values (45)"); //,\"arthro10\",3,\"kati2\",\"2014-10-23\",\"member2@network2.com\
		//	pst2.execute();
			PreparedStatement pst = conn.prepareStatement("insert into article_comment values (?,?,?,?,?)");
			
			for (int i=0;i<20000;i++) {
				pst.setInt(1, (i+109));
				pst.setString(2, "sxolio"+i);
				String dateOfBirth = Integer.toString(dateOfMonth3[getRandInt(dateOfMonth3.length)]);
				String dateOfBirth2 = Integer.toString(dateOfMonth2[getRandInt(dateOfMonth2.length)]);
				String dateOfBirth3 = Integer.toString(dateOfMonth[getRandInt(dateOfMonth.length)]);
				String imer = dateOfBirth+"-"+dateOfBirth2+"-"+dateOfBirth3;
				pst.setDate(3, java.sql.Date.valueOf(imer));
				pst.setInt(4, (i+18));
				randmember=4000+r.nextInt(10000-4000+1);
				pst.setString(5, "member"+randmember+"@network"+randmember+".com");
				pst.execute();
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void insertConnects() {
		int [] dateOfMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		int [] dateOfMonth2 = { 1, 2, 3, 4};
		int [] dateOfMonth3 = {2016};
		try {
		//	PreparedStatement pst2 = conn.prepareStatement("insert into public.article (articleid) values (45)"); //,\"arthro10\",3,\"kati2\",\"2014-10-23\",\"member2@network2.com\
		//	pst2.execute();
			PreparedStatement pst = conn.prepareStatement("insert into connects values (?,?,?,?,?)");
			
			for (int i=0;i<8000;i+=2) {
				//randmember=4000+r.nextInt(10000-4000+1);
				pst.setString(1, "member"+(i+20)+"@network"+(i+20)+".com");
				pst.setString(2, "member"+(i+21)+"@network"+(i+21)+".com");
				pst.setString(3, "kati"+i);
				pst.setString(4, "kati"+i);
				String dateOfBirth = Integer.toString(dateOfMonth3[getRandInt(dateOfMonth3.length)]);
				String dateOfBirth2 = Integer.toString(dateOfMonth2[getRandInt(dateOfMonth2.length)]);
				String dateOfBirth3 = Integer.toString(dateOfMonth[getRandInt(dateOfMonth.length)]);
				String imer = dateOfBirth+"-"+dateOfBirth2+"-"+dateOfBirth3;
				pst.setDate(5, java.sql.Date.valueOf(imer));
				pst.execute();
			}
			for (int i=0;i<8000;i+=2) {
				//randmember=4000+r.nextInt(10000-4000+1);
				pst.setString(1, "member"+(i+21)+"@network"+(i+21)+".com");
				
				pst.setString(2, "member"+(i+20)+"@network"+(i+20)+".com");
				pst.setString(3, "kati"+i);
				pst.setString(4, "kati"+i);
				String dateOfBirth = Integer.toString(dateOfMonth3[getRandInt(dateOfMonth3.length)]);
				String dateOfBirth2 = Integer.toString(dateOfMonth2[getRandInt(dateOfMonth2.length)]);
				String dateOfBirth3 = Integer.toString(dateOfMonth[getRandInt(dateOfMonth.length)]);
				String imer = dateOfBirth+"-"+dateOfBirth2+"-"+dateOfBirth3;
				pst.setDate(5, java.sql.Date.valueOf(imer));
				pst.execute();
			}
			for (int i=0;i<2000;i++) {
				//randmember=4000+r.nextInt(10000-4000+1);
				pst.setString(1, "member"+(i+20)+"@network"+(i+20)+".com");
				pst.setString(2, "member"+(i+10000)+"@network"+(i+10000)+".com");
				pst.setString(3, "kati"+i);
				pst.setString(4, "kati"+i);
				String dateOfBirth = Integer.toString(dateOfMonth3[getRandInt(dateOfMonth3.length)]);
				String dateOfBirth2 = Integer.toString(dateOfMonth2[getRandInt(dateOfMonth2.length)]);
				String dateOfBirth3 = Integer.toString(dateOfMonth[getRandInt(dateOfMonth.length)]);
				String imer = dateOfBirth+"-"+dateOfBirth2+"-"+dateOfBirth3;
				pst.setDate(5, java.sql.Date.valueOf(imer));
				pst.execute();
			}
			for (int i=0;i<2000;i++) {
				//randmember=4000+r.nextInt(10000-4000+1);
				pst.setString(1, "member"+(i+10000)+"@network"+(i+10000)+".com");
				pst.setString(2, "member"+(i+2100)+"@network"+(i+2100)+".com");
				pst.setString(3, "kati"+i);
				pst.setString(4, "kati"+i);
				String dateOfBirth = Integer.toString(dateOfMonth3[getRandInt(dateOfMonth3.length)]);
				String dateOfBirth2 = Integer.toString(dateOfMonth2[getRandInt(dateOfMonth2.length)]);
				String dateOfBirth3 = Integer.toString(dateOfMonth[getRandInt(dateOfMonth.length)]);
				String imer = dateOfBirth+"-"+dateOfBirth2+"-"+dateOfBirth3;
				pst.setDate(5, java.sql.Date.valueOf(imer));
				pst.execute();
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void insertEducation() {

		int [] dateOfMonth3 = {1999,2000,2001,2002};
		int [] dateOfMonth2 = {2004,2005,2006};
		int [] dateOfMonth4 = { 1,2,3,4};
		try {
		//	PreparedStatement pst2 = conn.prepareStatement("insert into public.article (articleid) values (45)"); //,\"arthro10\",3,\"kati2\",\"2014-10-23\",\"member2@network2.com\
		//	pst2.execute();
			PreparedStatement pst = conn.prepareStatement("insert into education values (?,?,?,?,?,?,?,?)");
			
			for (int i=0;i<11300;i++) {
				pst.setInt(1, (i+6));
				pst.setString(2, "country"+(i%100));
				pst.setString(3, "school"+(i%250));
				pst.setString(4, "edulvl"+(i%5));
				pst.setInt(5, dateOfMonth4[getRandInt(dateOfMonth4.length)]);
				pst.setInt(6, dateOfMonth3[getRandInt(dateOfMonth3.length)]);
				pst.setInt(7, dateOfMonth2[getRandInt(dateOfMonth2.length)]);
				pst.setString(8, "member"+i+"@network"+i+".com");
				pst.execute();
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public enum genders{
		male,
		female
	}
	public void insertMembers() {
		int[] dateDay = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}; 
		int[] dateMonth = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] dateYear = {2010, 2011, 2012, 2013, 2014, 2015, 2016};
		int[] dateByear = new int[26];
		String[] gender = {"male", "female"}; 
		{
			for (int i=0;i<26;i++){
				dateByear[i]=1970+i;
			}
		}

		Random r=new Random();
		
		try {
			PreparedStatement pst = conn.prepareStatement("insert into member values (?,?,?,?,?,?,?,?,?::genders,?)");
			int ranDay, ranMonth, ranYear, ranByear;
			String ranDate, ranBday, ranLogDay;
			for (int i=0;i<20000;i++) {
				pst.setString(1, "member"+(i+16)+"@network"+(i+16)+".com");
				pst.setString(2, "first"+(i+16));
				pst.setString(3, "last"+(i+16));
				pst.setString(4, "passwd"+(i+16));
				ranDay=dateDay[r.nextInt(dateDay.length)];
				ranMonth=dateMonth[r.nextInt(dateMonth.length)];
				ranYear=dateYear[r.nextInt(dateYear.length)];
				ranDate = Integer.toString(ranYear)+"-"+Integer.toString(ranMonth)+"-"+Integer.toString(ranDay);
				pst.setDate(5, java.sql.Date.valueOf(ranDate));
				ranDay=dateDay[r.nextInt(dateDay.length)];
				ranMonth=dateMonth[r.nextInt(dateMonth.length)];
				ranByear=dateByear[r.nextInt(dateByear.length)];
				ranBday = Integer.toString(ranByear)+"-"+Integer.toString(ranMonth)+"-"+Integer.toString(ranDay);
				pst.setDate(6, java.sql.Date.valueOf(ranBday));
				pst.setString(7, "country"+(i+16));
				pst.setInt(8, (i%5+3)*168 );
				pst.setString(9, gender[(r.nextInt(genders.values().length))]);
				ranDay=dateDay[r.nextInt(dateDay.length)];
				ranMonth=dateMonth[r.nextInt(dateMonth.length-7)];
				ranLogDay="2016"+"-"+Integer.toString(ranMonth)+"-"+Integer.toString(ranDay);
				pst.setDate(10, java.sql.Date.valueOf(ranLogDay));
				pst.execute();
				//this.commit();
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	// STEP 5 <-----
		
	public static void main(String[] args) {
		
		DbApp db = new DbApp();
		
		// STEP 2 ----->
		//String database = db.readConsole("Enter database:");
		//String username = db.readConsole("Enter username:");
		//String password = db.readConsole("Enter password:");
		//db.connect(database, username, password);
		// STEP 2 <-----
		db.connect(); //"db130516new", "postgres", "postgres"
		
		// STEP 6 ----->
/*		db.printMembers();
		db.readConsole("Press Enter to continue ..");
		db.insertMembers();
		db.printMembers();
		db.readConsole("Press Enter to continue ..");
		db.rollback();
		db.printMembers();*/
		// STEP 6 <-----
		//db.insertArticles();
		//db.insertMembers();
		//db.insertArticleComments();
		//db.insertConnects();
		//db.insertEducation();
		
		try {
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("Enter email: ");
		        String emailin = br.readLine();
			//String emailin = System.console().readLine();
			Statement st = db.conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT public.anaktisi8('"+emailin+"')");
			while (rs.next()) {
			System.out.println("result: "+rs.getString(1));
			}
			rs.close();
			st.close();
			}catch (Exception ex) {
			ex.printStackTrace();
			}
		try {
			 BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("Enter articleid: ");
		        int articleid = Integer.parseInt(br2.readLine());
		        System.out.print("Enter your comment: ");
		        String comment = br2.readLine();
			//String emailin = System.console().readLine();
			Statement st = db.conn.createStatement();
			System.out.print("Enter your email: ");
			String mail = br2.readLine();
			ResultSet rs2 = st.executeQuery("select max(commentid) from article_comment");
			rs2.next();
			int commid = rs2.getInt(1);
			System.out.println("New commentid: "+commid);
			 st.executeQuery("insert into article_comment(commentid,thecomment,articleid,email) values("+(commid+1)+", '"+comment+"', "+articleid+", '"+mail+"')");
			
			//rs.close();
			rs2.close();
			st.close();
			}catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }
		catch (Exception ex) {
			ex.printStackTrace();
			}
		
	}
}



