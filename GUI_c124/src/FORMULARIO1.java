import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FORMULARIO1 {

	private JFrame frmCursoJavaInicial;
	private JTextField txtNombre;
	private JTextField txtDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FORMULARIO1 window = new FORMULARIO1();
					window.frmCursoJavaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FORMULARIO1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCursoJavaInicial = new JFrame();
		frmCursoJavaInicial.setTitle("Curso Java inicial - 095");
		frmCursoJavaInicial.setBounds(100, 100, 745, 434);
		frmCursoJavaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(new Color(230, 230, 250));
		FlowLayout flowLayout = (FlowLayout) pnlTop.getLayout();
		flowLayout.setVgap(15);
		frmCursoJavaInicial.getContentPane().add(pnlTop, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("FORMULARIO DE INGRESO DE ALUMNOS");
		lblTitulo.setForeground(new Color(128, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlTop.add(lblTitulo);
		
		JPanel pnlCarga = new JPanel();
		frmCursoJavaInicial.getContentPane().add(pnlCarga, BorderLayout.CENTER);
		pnlCarga.setLayout(null);
		
		JLabel lblNombre = new JLabel("Datos:");
		lblNombre.setBounds(156, 31, 44, 14);
		pnlCarga.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(244, 28, 201, 20);
		pnlCarga.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDNI = new JLabel("Tipo Validación:");
		lblDNI.setBounds(132, 66, 97, 14);
		pnlCarga.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(441, 202, 159, 20);
		pnlCarga.add(txtDNI);
		txtDNI.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 281, 729, 59);
		panel.setVisible(false);
		pnlCarga.add(panel);
		
		//objeto de tipo JButton 
		JButton btnAceptar = new JButton("ACEPTAR");
		// Metodo de Objeto btnAceptar (Click)
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumnos Alumno = new Alumnos();
			int dnis= Integer.parseInt(txtDNI.getText());
			String Nombres= txtNombre.getText();
			boolean resultadoOp =Alumno.GuardarAlumnos(dnis,Nombres);
			if(resultadoOp) {
				System.out.println("alumno ingresado correctamente");
			}
			else {
				System.out.println("hubo un error en la carga de datos");
			}
			}
		});
		panel.add(btnAceptar);
		
		JLabel lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(new Color(255, 153, 0));
		lblError.setBackground(new Color(255, 153, 0));
		lblError.setBounds(0, 256, 729, 23);
		pnlCarga.add(lblError);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDNI.setText("no cambiar");
				txtNombre.setText("");
			}
		});
		panel.add(btnCancelar);
		
		JButton btnMostrar = new JButton("Mostrar Alumnos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumnos Alumno = new Alumnos();
				String resultadoOp2 = Alumno.MostrarAlumnos();
				
				lblError.setText(resultadoOp2);
			
				
			}
		});
		btnMostrar.setBounds(465, 148, 235, 23);
		pnlCarga.add(btnMostrar);
		
		JButton btnDos = new JButton("btnDos");
		btnDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblError.setText("hice click en boton dos");
				btnMostrar.setText("dos");
				
			}
		});
			JLabel lblico1 = new JLabel("");
			lblico1.setIcon(new ImageIcon(FORMULARIO1.class.getResource("/icons/full/message_error.png")));
			lblico1.setBounds(462, 31, 15, 14);
			lblico1.setVisible(false);
			pnlCarga.add(lblico1);
			
			JLabel lblico2 = new JLabel("");
			lblico2.setIcon(new ImageIcon(FORMULARIO1.class.getResource("/icons/full/message_info.png")));
			lblico2.setBounds(487, 31, 20, 14);
			lblico2.setVisible(false);
			pnlCarga.add(lblico2);
			
		
		btnDos.setBounds(110, 148, 89, 23);
		pnlCarga.add(btnDos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecciones una opción", "1 - Fechas", "2 -DNI", "3 - Email"}));
		comboBox.setBounds(244, 62, 201, 22);
		pnlCarga.add(comboBox);
		JButton btnValidaExpr = new JButton("Validar");
		btnValidaExpr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean Resultado=	ExpRegFechas(txtNombre.getText(), comboBox.getSelectedIndex());
				lblError.setText(Resultado? "Expresión Correcta" : "Expresión Incorrecta");
				if(Resultado) {
					lblico2.setVisible(Resultado);
					lblico1.setVisible(false);
				}else {
					lblico2.setVisible(Resultado);
					lblico1.setVisible(true);
				};
				
				
				
			}
		});
		btnValidaExpr.setBounds(455, 62, 89, 23);
		pnlCarga.add(btnValidaExpr);
		
		
		
		
		
	
	}
 static boolean ExpRegFechas(String dato, int TipoValidacion) {
	
		
		switch (TipoValidacion) {
		case 0: 
			System.out.println("Seleccione opción");
			return false;
		case 1: //valida fecha
			String regexp1 = "\\d{1,2}/\\ | - \\d{1,2}/\\\\ | -\\d{4}";
			
		System.out.println(Pattern.matches(regexp1, dato));
		if (Pattern.matches(regexp1, dato))
		{return true;}
	else{return false;}
		
		case 2: //DNI
			String regexp2 = "\\d{8}";
		System.out.println(Pattern.matches(regexp2, dato));
		if (Pattern.matches(regexp2, dato))
		{return true;}
	else{return false;}
		case 3: //valida email
			String regexp3 = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
			String regexp4= "[a-z]|[0-9])+@[a-z]+\\.[a-z]+";
		if (Pattern.matches(regexp4, dato))
			{return true;}
		else{return false;}
		default:
			System.out.println("No existe esa opción");
			return false;
		}
	}
}
