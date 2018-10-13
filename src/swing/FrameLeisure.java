package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

import data.Data;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FrameLeisure extends JFrame{
	private JButton btnAceptar, btnCancelar;
	private JComboBox cityComboBox, dayComboBox;
	public FrameLeisure() {
		setResizable(false);
		setVisible(true);
		setTitle("Config");
		setBounds(200,200,300,160);
		getContentPane().setLayout(null);
		
		JLabel lblSeleccionarCiudad = new JLabel("Seleccionar ciudad");
		lblSeleccionarCiudad.setBounds(10, 24, 137, 14);
		getContentPane().add(lblSeleccionarCiudad);
		
		cityComboBox = new JComboBox();
		cityComboBox.setBounds(147, 21, 137, 20);
		cityComboBox.setModel(new DefaultComboBoxModel(Data.getCities()));
		getContentPane().add(cityComboBox);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 55, 46, 14);
		getContentPane().add(lblFecha);
		
		dayComboBox = new JComboBox();
		dayComboBox.setModel(new DefaultComboBoxModel(Data.getTripIntValues(1, 31)));
		dayComboBox.setBounds(93, 52, 44, 20);
		getContentPane().add(dayComboBox);
		
		JComboBox monthComboBox = new JComboBox();
		monthComboBox.setEnabled(false);
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"Mayo"}));
		monthComboBox.setBounds(147, 52, 65, 20);
		getContentPane().add(monthComboBox);
		
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setEnabled(false);
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"2018"}));
		yearComboBox.setBounds(222, 52, 62, 20);
		getContentPane().add(yearComboBox);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(168, 91, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(47, 91, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
