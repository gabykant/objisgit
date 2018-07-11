package com.objis.impl;

import com.objis.util.Etudiant;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEtudiant extends Remote{
	public void saveEtudiant(Etudiant e) throws RemoteException;
	public void editEtudiant(int id) throws RemoteException;
	public void updateEtudiant(Etudiant e) throws RemoteException;
	public List<Etudiant> listEtudiant() throws RemoteException;
}