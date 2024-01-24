package moneda;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class Canary_Exchange extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField importeInicial;
	private JTextField cambioRealizado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Canary_Exchange frame = new Canary_Exchange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Canary_Exchange() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Canary_Exchange.class.getResource("/moneda/Imagenes/pajaroto.png")));
		setTitle("Canary Exchange");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Centra la ventana a la salida el setLocationRelativeTo
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel etiquetaImporte = new JLabel("AÑADIR IMPORTE");
		etiquetaImporte.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImporte.setFont(new Font("Candara", Font.BOLD, 16));
		etiquetaImporte.setBounds(88, 25, 122, 30);
		contentPane.add(etiquetaImporte);

		JLabel etiquetaResultado = new JLabel("CAMBIO");
		etiquetaResultado.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaResultado.setFont(new Font("Candara", Font.BOLD, 16));
		etiquetaResultado.setBounds(252, 100, 58, 30);
		contentPane.add(etiquetaResultado);
		cambioRealizado = new JTextField();
		cambioRealizado.setEnabled(false);
		cambioRealizado.setEditable(false);
		cambioRealizado.setForeground(Color.BLACK);
		cambioRealizado.setFont(new Font("Dialog", Font.BOLD, 12));
		cambioRealizado.setHorizontalAlignment(SwingConstants.RIGHT);
		cambioRealizado.setColumns(10);
		cambioRealizado.setBounds(30, 135, 280, 40);
		contentPane.add(cambioRealizado);

		JLabel indicadorMonetario = new JLabel("");
		indicadorMonetario.setFont(new Font("Dialog", Font.BOLD, 12));
		indicadorMonetario.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorMonetario.setBounds(149, 91, 40, 40);
		contentPane.add(indicadorMonetario);

		importeInicial = new JTextField();

		importeInicial.setFont(new Font("Dialog", Font.BOLD, 12));
		importeInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		importeInicial.setForeground(SystemColor.activeCaptionText);
		importeInicial.setBounds(30, 50, 180, 40);
		contentPane.add(importeInicial);
		importeInicial.setColumns(10);

		//	CaretListener Al detectar cambios en algun caracter se produce la accion
		importeInicial.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				cambioRealizado.setText("");
				indicadorMonetario.setText("");
			}
		});

		JButton dolarButton = new JButton("Dolares");
		dolarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dolarButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		dolarButton.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				int valorImporteInicial;
				double valorCambioRealizado;
				final double DOLAR =  0.9189;	// cambio de dolares a euros
				String input = importeInicial.getText();

				if (input.matches("\\d+")) {
					valorImporteInicial = Integer.parseInt(input);
					valorCambioRealizado = valorImporteInicial * DOLAR;
					try {
						cambioRealizado.setText(String.format("%.2f", valorCambioRealizado));
						indicadorMonetario.setText("$ ~ €");
					} catch (Exception ex) {
						cambioRealizado.setText("Error de cálculo.");
						indicadorMonetario.setText("");
					}
				}else {
					if (!input.isBlank()) {
						cambioRealizado.setText("Error importe no válido introducido.");
						indicadorMonetario.setText("");
					}				
				}
			}
		});
		dolarButton.setBounds(30, 220, 110, 40);
		contentPane.add(dolarButton);

		JButton librasButton = new JButton("Libras");
		librasButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		librasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		librasButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int valorImporteInicial;
				double valorCambioRealizado;
				final double LIBRAS = 0.8581;	// cambio de libras a euros
				String input = importeInicial.getText();

				if (input.matches("\\d+")) {
					valorImporteInicial = Integer.parseInt(input);
					valorCambioRealizado = valorImporteInicial * LIBRAS;
					try {
						cambioRealizado.setText(String.format("%.2f", valorCambioRealizado));
						indicadorMonetario.setText("£ ~ €");
					} catch (Exception ex) {
						cambioRealizado.setText("Error de cálculo.");
						indicadorMonetario.setText("");
					}
				}else {
					if (!input.isBlank()) {
						cambioRealizado.setText("Error importe no válido introducido.");
						indicadorMonetario.setText("");
					}			
				}
			}
		});
		librasButton.setBounds(200, 220, 110, 40);
		contentPane.add(librasButton);

		JButton rublosButton = new JButton("Rublos");
		rublosButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		rublosButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int valorImporteInicial;
				double valorCambioRealizado;
				final double RUBLOS = 0.01037;	// cambio de rublos a euros
				String input = importeInicial.getText();

				if (input.matches("\\d+")) {
					valorImporteInicial = Integer.parseInt(input);
					valorCambioRealizado = valorImporteInicial * RUBLOS;
					try {
						cambioRealizado.setText(String.format("%.2f", valorCambioRealizado));
						indicadorMonetario.setText("₽ ~ €");
					} catch (Exception ex) {
						cambioRealizado.setText("Error de cálculo.");
						indicadorMonetario.setText("");
					}
				}else {
					if (!input.isBlank()) {
						cambioRealizado.setText("Error importe no válido introducido.");
						indicadorMonetario.setText("");
					}		
				}
			}
		});
		rublosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		rublosButton.setBounds(30, 290, 110, 40);
		contentPane.add(rublosButton);

		JButton yenesButton = new JButton("Yenes");
		yenesButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		yenesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int valorImporteInicial;
				double valorCambioRealizado;
				final double YENES = 0.006201;	// cambio de yenes a euros
				String input = importeInicial.getText();

				if (input.matches("\\d+")) {
					valorImporteInicial = Integer.parseInt(input);
					valorCambioRealizado = valorImporteInicial * YENES;
					try {
						cambioRealizado.setText(String.format("%.2f", valorCambioRealizado));
						indicadorMonetario.setText("¥ ~ €");
					} catch (Exception ex) {
						cambioRealizado.setText("Error de cálculo");
						indicadorMonetario.setText("");
					}
				}else {
					if (!input.isBlank()) {
						cambioRealizado.setText("Error importe no válido introducido.");
						indicadorMonetario.setText("");
					}
				}
			}
		});
		yenesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		yenesButton.setBounds(200, 290, 110, 40);
		contentPane.add(yenesButton);

		JButton limpiarButton = new JButton("Limpiar");
		limpiarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cambioRealizado.setText("");
					importeInicial.setText("");
					indicadorMonetario.setText("");
				} catch (Exception ex) {
					cambioRealizado.setText("Error no registrado.");
					indicadorMonetario.setText("");
				}
			}
		});
		limpiarButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		limpiarButton.setBounds(220, 50, 90, 40);
		contentPane.add(limpiarButton);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{etiquetaImporte, importeInicial, limpiarButton, etiquetaResultado, cambioRealizado, indicadorMonetario, dolarButton, librasButton, rublosButton, yenesButton}));


	}
}
