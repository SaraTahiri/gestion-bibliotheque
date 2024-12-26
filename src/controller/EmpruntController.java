package controller;
import emprunt.Emprunt;
import emprunt.ModeleEmprunt;
import view.EmpruntFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class EmpruntController {
	
	
	    private ModeleEmprunt modele;
	    private EmpruntFrame view;

	    public EmpruntController(ModeleEmprunt modele, EmpruntFrame view) {
	        this.modele = modele;
	        this.view = view;
             intialiserController();
	        
	    }
	    public void intialiserController() {
	    	view.getBtnAjouter().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ajouterListener();
				}
	    		
	    	});
	    	view.getBtnSupprimer().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					supprimerListener();
				}
	    		
	    	});
	    	
	    	view.getBtnRechercher().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					rechercherListener();
				}
	    		
	    	});
	    	
	    	
	        afficherLaListeDesEmprunt();
	        }

	    
	    public void ajouterListener() {
	    	
	    	  try {
	                Emprunt emprunt = new Emprunt();
	                emprunt.setId(Integer.parseInt(view.getTxtID()));
	                emprunt.setLivre(view.getTxtLivre());
	                emprunt.setIduser(Integer.parseInt(view.getTxtUtilisateur()));
	                emprunt.setDateEmprunt(LocalDate.parse(view.getTxtDateEmprunt()));
	                emprunt.setDateRetourPrevue(LocalDate.parse(view.getTxtDateRetourPrevue()));
	                modele.ajouterEmprunt(emprunt);
	                JOptionPane.showMessageDialog(view, "Emprunt ajouté avec succès !");
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage());
	            }
	        }
	    public void supprimerListener() {
	    	int selecetedRow =view.table.getSelectedRow();
	    	if(selecetedRow==-1) {
	    		JOptionPane.showMessageDialog(view, "Veuillez sélectionner une Emprunt à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
	            return;
	    	}
	    	try {
	                int id = Integer.parseInt(view.getTxtID());
	                modele.supprimerEmprunt(id);
	                JOptionPane.showMessageDialog(view, "Emprunt supprimé avec succès !");
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage());
	            }
	        }
	    public void rechercherListener() {
	    	
	    }
	    
	    public void afficherLaListeDesEmprunt() {
	        modele.lireCSV();

	        DefaultTableModel tableModel = (DefaultTableModel) view.table.getModel();
	        tableModel.setRowCount(0);

	        for (Emprunt emprunts : modele.listerEmprunt()) {
	            tableModel.addRow(new Object[]{emprunts.getId(),emprunts.getLivre() ,emprunts.getIduser() ,  emprunts.getDateEmprunt(),emprunts.getDateRetourPrevue()});
	        }
	    }
	}


