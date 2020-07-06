package com.example.demo;

import com.example.demo.dao.EntityDAO;
import com.example.demo.model.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {


		SpringApplication.run(DemoApplication.class, args);

		String original;
		List<String> list = new ArrayList<>();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a string/number to check if it is a palindrome");

		original = in.nextLine();

		Pattern p = Pattern.compile("[a-zA-Z0-9]+");
		Matcher m1 = p.matcher(original);

		while (m1.find()) {
			list.add(m1.group());
		}

		System.out.println(list);

		for ( String element : list ) {

			int length = element.length();

			String reverse = "";
			for ( int i = length - 1; i >= 0; i-- )

				reverse = reverse + element.charAt(i);

			if (element.equals(reverse)){
				System.out.println("Element : " + element + " is a palindrome.");

				Session session = null;
				Transaction tx = null;

				try {

					/*Configuration c = new Configuration();
					c.configure("application.properties");
					SessionFactory sf = c.buildSessionFactory();
					session = sf.openSession();*/

					/*if (entityManager == null
							|| (session = entityManager.unwrap(Session.class)) == null) {

						throw new NullPointerException();
					}

					Data singleData = null;

					tx = session.beginTransaction();

					singleData = new Data();
					singleData.setText(element);
					session.save(singleData);

					tx.commit();*/



				} catch (RuntimeException e) {
					try {
						tx.rollback();
					} catch (RuntimeException rbe) {
						System.err.println("Couldn’t roll back transaction"+ rbe);
					}
					throw e;
				} finally{
					if(session != null){
						session.close();
					}
				}
			}
		}
	}

}
