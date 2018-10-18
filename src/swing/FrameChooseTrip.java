package swing;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import data.Data;

import javax.swing.JLabel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class FrameChooseTrip extends JFrame{
	private JButton btnAceptar, btnCancelar;
	private JComboBox cityComboBox, dayStartComboBox, dayEndComboBox;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameChooseTrip() {
		setResizable(false);
		setVisible(true);
		setTitle("Config");
		getContentPane().setLayout(null);
		setBounds(200,200,317,186);
		
		JLabel lblNewLabel = new JLabel("Seleccionar la ciudad");
		lblNewLabel.setBounds(10, 14, 180, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSeleccionarFechas = new JLabel("Fecha Inicio");
		lblSeleccionarFechas.setBounds(10, 42, 81, 14);
		getContentPane().add(lblSeleccionarFechas);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(162, 113, 108, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(31, 113, 103, 23);
		getContentPane().add(btnCancelar);
		
		cityComboBox = new JComboBox();
		cityComboBox.setModel(new DefaultComboBoxModel(Data.getDefaultCities()));
		cityComboBox.setBounds(200, 11, 90, 20);
		getContentPane().add(cityComboBox);
		
		dayStartComboBox = new JComboBox();
		dayStartComboBox.setModel(new DefaultComboBoxModel(Data.getTripIntValues(1, 30)));
		dayStartComboBox.setBounds(101, 39, 51, 20);
		getContentPane().add(dayStartComboBox);
		
		JComboBox monthStartComboBox = new JComboBox();
		monthStartComboBox.setEnabled(false);
		monthStartComboBox.setModel(new DefaultComboBoxModel(new String[] {"Mayo"}));
		monthStartComboBox.setBounds(162, 39, 59, 20);
		getContentPane().add(monthStartComboBox);
		
		JComboBox yearStartComboBox = new JComboBox();
		yearStartComboBox.setEnabled(false);
		yearStartComboBox.setModel(new DefaultComboBoxModel(new String[] {"2018"}));
		yearStartComboBox.setBounds(231, 39, 59, 20);
		getContentPane().add(yearStartComboBox);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(10, 70, 81, 14);
		getContentPane().add(lblFechaFin);
		
		dayEndComboBox = new JComboBox();
		dayEndComboBox.setModel(new DefaultComboBoxModel<>(Data.getTripIntValues(2, 31)));
		dayEndComboBox.setBounds(101, 67, 51, 20);
		getContentPane().add(dayEndComboBox);
		
		JComboBox monthEndComboBox = new JComboBox();
		monthEndComboBox.setModel(new DefaultComboBoxModel(new String[] {"Mayo"}));
		monthEndComboBox.setEnabled(false);
		monthEndComboBox.setBounds(162, 67, 59, 20);
		getContentPane().add(monthEndComboBox);
		
		JComboBox yearEndComboBox = new JComboBox();
		yearEndComboBox.setModel(new DefaultComboBoxModel(new String[] {"2018"}));
		yearEndComboBox.setEnabled(false);
		yearEndComboBox.setBounds(231, 67, 59, 20);
		getContentPane().add(yearEndComboBox);
		
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public int getStartDay() {
		return Integer.parseInt((String)dayStartComboBox.getSelectedItem());
	}
	public int getEndDay() {
		return Integer.parseInt((String)dayEndComboBox.getSelectedItem());
	}
	public String getCity() {
		return (String) cityComboBox.getSelectedItem();
	}
	
	public boolean checkCorrectInterval() {
		if(Integer.parseInt((String) dayStartComboBox.getSelectedItem())>Integer.parseInt((String) dayEndComboBox.getSelectedItem())) {
			return false;
		}else
			return true;
	}
	
	
	
}
