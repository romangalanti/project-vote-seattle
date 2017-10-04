package com.theironyard.projectvote.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.theironyard.projectvote.models.*;
import com.theironyard.projectvote.repositories.*;

@Configuration
public class SeedData {

	@SuppressWarnings("unused")
	public SeedData(SeedRepository seed, @Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String dbuser, @Value("${spring.datasource.password}") String dbpwd) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		try {
			Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(SeedData.schema());
			conn.close();
		} catch (Exception e) {}
		
		Student aj = seed.createIf("AJ", "Amoranto");
		Student alexis = seed.createIf("Alexis", "Constantakos");
		Student amandam = seed.createIf("Amanda", "Maifeld");
		Student bryan = seed.createIf("Bryan", "Griffin");
		Student christina = seed.createIf("Christina", "Amberson");
		Student erin = seed.createIf("Erin", "Flaherty");
		Student rudy = seed.createIf("Rudy", "Morosoff");
		Student helena = seed.createIf("Helena", "Witzke");
		Student jeramiah = seed.createIf("Jeramiah", "Diegel");
		Student joseph = seed.createIf("Joseph", "Mar");
		Student jourdan = seed.createIf("Jourdan", "Hamerly");
		Student kelsey = seed.createIf("Kelsey", "Beffel");
		Student landen = seed.createIf("Landen", "Wasserstrom");
		Student leah = seed.createIf("Leah", "Johnson");
		Student lyndsay = seed.createIf("Lyndsay", "Buban");
		Student mike = seed.createIf("Mike", "Johnstone");
		Student ruben = seed.createIf("Ruben", "Acosta");
		Student terri = seed.createIf("Terri", "Kolb");

		Student alex = seed.createIf("Alex", "Karp");
		Student amandak = seed.createIf("Amanda", "Konenkamp");
		Student ben = seed.createIf("Ben", "Brandvig");
		Student chad = seed.createIf("Chad", "Riley");
		Student dan = seed.createIf("Dan", "Spindler");
		Student gerry = seed.createIf("Gerry", "Bradley");
		Student james = seed.createIf("James", "Decker");
		Student jasmine = seed.createIf("Jasmine", "Stotts");
		Student jean = seed.createIf("Jean", "Stam");
		Student jon = seed.createIf("Jon", "Podosek");
		Student joshua = seed.createIf("Joshua", "Holt");
		Student luka = seed.createIf("Luka", "Ralic");
		Student matt = seed.createIf("Matt", "Fujita");
		Student nick = seed.createIf("Nick", "Poole");
		Student peter = seed.createIf("Peter", "Boudreau");
		Student priya = seed.createIf("Priya", "Prabhakar");
		Student rachel = seed.createIf("Rachel", "Soley");
		Student roman = seed.createIf("Roman", "Galanti");
		Student serena = seed.createIf("Serena", "Zywicki");
		Student tania = seed.createIf("Tania", "Asim");
		Student trace = seed.createIf("Trace", "Ferre");
		
		seed.createIf("Curtis", "Schlak");
		seed.createIf("Eric", "Schwartz");
		
		ProjectCategory charity = seed.createIf("Charity");
		ProjectCategory productivity = seed.createIf("Productivity");
		ProjectCategory social = seed.createIf("Social");
		ProjectCategory game = seed.createIf("Game");
		ProjectCategory data = seed.createIf("Data");
		ProjectCategory health = seed.createIf("Health");
		ProjectCategory finance = seed.createIf("Finance");
		ProjectCategory business = seed.createIf("Business");
		
		seed.createIf(productivity, helena, "Travel aid memory helper");
		seed.createIf(social, erin, "Web-based book club");
		seed.createIf(charity, lyndsay, "Charity needs monitor");
		seed.createIf(social, terri, "Happy hour list");
		seed.createIf(social, jeramiah, "Tinder for local food");
		seed.createIf(social, christina, "Bar crawl mapper");
		seed.createIf(game, landen, "Themed, updated Oregon Trail");
		seed.createIf(productivity, amandam, "Task list gamified");
		seed.createIf(social, gerry, "Angie's list for service providers");
		seed.createIf(productivity, priya, "Grocery Gallery");
		seed.createIf(data, jean, "App monitoring");
		seed.createIf(social, ben, "Community shed");
		seed.createIf(health, amandak, "BlazeBit");
		seed.createIf(health, jon, "Find a park");
		seed.createIf(productivity, luka, "eRAM: Enterprise Retrospective Analytics Monitoring");
		seed.createIf(productivity, dan, "Meal preparation planner");
		seed.createIf(finance, alex, "Loan Shark");
		seed.createIf(health, jasmine, "Motivational pedometer");
		seed.createIf(social, tania, "BRB");
		seed.createIf(productivity, james, "The Bucket List");
		seed.createIf(productivity, chad, "Lyft Primetime");
		seed.createIf(data, peter, "Data mapping for applications");
		seed.createIf(business, bryan, "Music store inventory");
		seed.createIf(social, ruben, "Next Gathering");
		seed.createIf(social, mike, "YAH!");
		seed.createIf(social, jourdan, "Social for Dogs");
		seed.createIf(social, aj, "EatnWatch");
		seed.createIf(data, joseph, "Data attribute governance");
		seed.createIf(business, rudy, "Music portfolio app");
		seed.createIf(business, rudy, "College review site");
		
		seed.createIf(social, luka, "SKETCH-E");
		seed.createIf(social, dan, "Public bathroom rating app (Castanza App)");
	}
	
	private static String schema() {
		return "CREATE SEQUENCE hibernate_sequence" +
				"    START WITH 1" +
				"    INCREMENT BY 1" +
				"    NO MINVALUE" +
				"    NO MAXVALUE" +
				"    CACHE 1;" +
				"" +
				"" +
				"CREATE TABLE project (" +
				"    id bigint NOT NULL," +
				"    description character varying(255)," +
				"    name character varying(255)," +
				"    category_id bigint," +
				"    creator_id bigint" +
				");" +
				"" +
				"" +
				"CREATE TABLE project_category (" +
				"    id bigint NOT NULL," +
				"    icon character varying(255)," +
				"    name character varying(255)" +
				");" +
				"" +
				"" +
				"CREATE TABLE project_votes (" +
				"    project_id bigint NOT NULL," +
				"    votes_id bigint NOT NULL" +
				");" +
				"" +
				"CREATE TABLE student (" +
				"    id bigint NOT NULL," +
				"    first_name character varying(255)," +
				"    last_name character varying(255)," +
				"    first_id bigint," +
				"    second_id bigint," +
				"    third_id bigint" +
				");" +
				"" +
				"ALTER TABLE ONLY project_category" +
				"    ADD CONSTRAINT project_category_pkey PRIMARY KEY (id);" +
				"" +
				"ALTER TABLE ONLY project" +
				"    ADD CONSTRAINT project_pkey PRIMARY KEY (id);" +
				"" +
				"ALTER TABLE ONLY student" +
				"    ADD CONSTRAINT student_pkey PRIMARY KEY (id);" +
				"" +
				"ALTER TABLE ONLY project" +
				"    ADD CONSTRAINT fk3gxkqhaf86vo2jwt6yjxtdqiv FOREIGN KEY (category_id) REFERENCES project_category(id);" +
				"" +
				"ALTER TABLE ONLY student" +
				"    ADD CONSTRAINT fkcbi4cow0ni298h286ahxogd4u FOREIGN KEY (third_id) REFERENCES project(id);" +
				"" +
				"ALTER TABLE ONLY student" +
				"    ADD CONSTRAINT fkeavklvx8w6prt9de157pvoykl FOREIGN KEY (second_id) REFERENCES project(id);" +
				"" +
				"ALTER TABLE ONLY project_votes" +
				"    ADD CONSTRAINT fkidv0odr7shq81gpcnabwf207w FOREIGN KEY (project_id) REFERENCES project(id);" +
				"" +
				"ALTER TABLE ONLY project" +
				"    ADD CONSTRAINT fkoib2kp3r2vlpbw8q1ecg9pm8c FOREIGN KEY (creator_id) REFERENCES student(id);" +
				"" +
				"ALTER TABLE ONLY project_votes" +
				"    ADD CONSTRAINT fks5my8l8kj11s5y83w794lxsfn FOREIGN KEY (votes_id) REFERENCES project(id);" +
				"" +
				"ALTER TABLE ONLY student" +
				"    ADD CONSTRAINT fks7sqkvd2tf0s6guvjqxreaelv FOREIGN KEY (first_id) REFERENCES project(id);";
	}
	
}
