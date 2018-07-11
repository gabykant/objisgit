package com.objis.util;

import java.io.Serializable;

public class Etudiant implements Serializable{
	private String nom;
	private String prenom;
	private int id;

	public Etudiant(){
		this.nom = "a";
		this.prenom = "b";
	}

	public String getNom(){return nom;}
	public void setNom(String n){ this.nom = n; }

	public String getPrenom(){return prenom;}
	public void setPrenom(String n){ this.prenom = n; }

	public int getId(){return id;}
	public void setId(int t){ this.id = t; }

	@Override
	public String toString(){
		return "[ Etudiant : ID " + this.id + " - Nom " + this.nom + " - Prenom " + this.prenom + "]";
	}
}