package com.objis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.objis.util.Etudiant;
import java.util.List;
import java.util.ArrayList;

public class DBConnexion{
	
	String url = "jdbc:mysql://localhost:3306/rmi?autoReconnect=true&useSSL=false";
	String username = "root";
	String mdp = "";
	Connection strCon;
	
	public void insert_element(Etudiant etudiant) {
		try{
			// Etape 1: Récupération de la connexion
			Connection cn = DriverManager.getConnection(url, username, mdp);
		
			// Etape 2: Création d'un statement
			Statement st = cn.createStatement();
		
			String sql = "INSERT INTO etudiant VALUES (null, '" + etudiant.getNom() + "', '" + etudiant.getPrenom() + "')";
		
			// Etape 3: Exécution requête
			st.executeUpdate(sql);
		
			// Etape 4: Gestion des Exceptions et libération 'automatique' des ressources
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void delete_element(int n){
		try{
			// Etape 1: Récupération de la connexion
			Connection cn = DriverManager.getConnection(url, username, mdp);
		
			// Etape 2: Création d'un statement
			Statement st = cn.createStatement();
		
			String sql = "DELETE FROM etudiant WHERE id=" + n +" ";
		
			// Etape 3: Exécution requête
			st.executeUpdate(sql);
		
			// Etape 4: Gestion des Exceptions et libération 'automatique' des ressources
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void update_element(Etudiant etudiant){
		try{
			// Etape 1: Récupération de la connexion
			Connection cn = DriverManager.getConnection(url, username, mdp);
		
			// Etape 2: Création d'un statement
			Statement st = cn.createStatement();
		
			String sql = "UPDATE etudiant SET nom='"+ etudiant.getNom() +"', prenom='"+ etudiant.getPrenom() +"' WHERE id="+etudiant.getId()+" ";
		
			// Etape 3: Exécution requête
			st.executeUpdate(sql);
		
			// Etape 4: Gestion des Exceptions et libération 'automatique' des ressources
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Etudiant> list_element(){
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		try{
			// Etape 1: Récupération de la connexion
			Connection cn = DriverManager.getConnection(url, username, mdp);
		
			// Etape 2: Création d'un statement
			Statement st = cn.createStatement();
		
			String sql = "SELECT * FROM etudiant";
		
			// Etape 3: Exécution requête
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				Etudiant e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				etudiants.add(e);
			}
			
			st.close();
			cn.close();
			
			

			// Etape 4: Gestion des Exceptions et libération 'automatique' des ressources
		} catch (SQLException e){
			e.printStackTrace();
		}

		return etudiants;
	}
}