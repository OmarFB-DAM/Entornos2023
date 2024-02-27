import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.JFormattedTextField;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.event.CaretListener;
import javax.swing.text.NumberFormatter;
import javax.swing.event.CaretEvent;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Cursor;

public class TipMaster extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JTextField entradaTextoImporte;
	private static JTextField resultadoFactura;
	private static JTextField porcentajePropinaTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Locale locale = new Locale("es", "ES");
		Locale.setDefault(locale);   
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipMaster frame = new TipMaster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void gestionarAccionDesplegable(JComboBox desplegablePorcentajes) {
		String input;
		int seleccion;
		input = entradaTextoImporte.getText();
		seleccion = desplegablePorcentajes.getSelectedIndex();
		if (esUnDouble(input)) {
			
			double valorImporteInicial = Double.valueOf(input.replace(',', '.'));
			double valorPropina, valorTotal;
			switch (seleccion) {
			case 1:	//	caso 5%
				valorPropina = 0.05 * valorImporteInicial;
				valorTotal = valorPropina + valorImporteInicial;
				porcentajePropinaTexto.setText(String.format("%.2f", valorPropina) + " €");
				resultadoFactura.setText(String.format("%.2f", valorTotal) + " €");
				break;
			case 2: //	caso 10%
				valorPropina = 0.10 * valorImporteInicial;
				valorTotal = valorPropina + valorImporteInicial;
				porcentajePropinaTexto.setText(String.format("%.2f", valorPropina) + " €");
				resultadoFactura.setText(String.format("%.2f", valorTotal) + " €");
				break;
			case 3: //	caso 15% 
				valorPropina = 0.15 * valorImporteInicial;
				valorTotal = valorImporteInicial + valorPropina;
				porcentajePropinaTexto.setText(String.format("%.2f", valorPropina) + " €");
				resultadoFactura.setText(String.format("%.2f", valorTotal) + " €");
				break;
			case 4: //	caso 20% 
				valorPropina = 0.20 * valorImporteInicial;
				valorTotal = valorImporteInicial + valorPropina;
				porcentajePropinaTexto.setText(String.format("%.2f", valorPropina) + " €");
				resultadoFactura.setText(String.format("%.2f", valorTotal) + " €");
				break;
			default: desplegablePorcentajes.setSelectedIndex(-1);
			break;
			}

		} else {
			if (!input.isBlank()) {
					entradaTextoImporte.setText("Introduce un valor numérico.");
					porcentajePropinaTexto.setText("");
					resultadoFactura.setText("");
			}
		}
	}


	public boolean esUnDouble(String input) {
		return input.matches("\\d+(\\,\\d+)?") || input.matches("\\d+(\\.\\d+)?");
	}

	/**
	 * Create the frame.
	 */
	public TipMaster() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TipMaster.class.getResource("/imagenes/north-store-icons-03.png")));
		Locale locale = new Locale("es", "ES");
		Locale.setDefault(locale); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 340);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);

		JLabel label = new JLabel();
		contentPane.add(label, BorderLayout.CENTER);
		
		JLabel peticionImporteLabel = new JLabel("Ingrese el importe de su factura");
		peticionImporteLabel.setBounds(30, 35, 200, 14);
		peticionImporteLabel.setFont(new Font("Candara", Font.BOLD, 14));
		peticionImporteLabel.setHorizontalAlignment(SwingConstants.CENTER);

		//entradaTextoImporte = new JFormattedTextField(new NumberFormatter(new DecimalFormat("###,###.##")));
		entradaTextoImporte = new JTextField();
		entradaTextoImporte.setBounds(30, 60, 160, 30);
		entradaTextoImporte.setLocale(new Locale("es", "ES"));
		entradaTextoImporte.setHorizontalAlignment(SwingConstants.RIGHT);
		entradaTextoImporte.setColumns(10);

		JLabel propinasLabel = new JLabel("Selector de propinas");
		propinasLabel.setBounds(291, 35, 139, 14);
		propinasLabel.setFont(new Font("Candara", Font.BOLD, 14));
		propinasLabel.setHorizontalAlignment(SwingConstants.CENTER);

		resultadoFactura = new JTextField();
		resultadoFactura.setBounds(310, 234, 160, 30);
		resultadoFactura.setLocale(new Locale("es", "ES"));
		resultadoFactura.setEditable(false);
		resultadoFactura.setHorizontalAlignment(SwingConstants.RIGHT);
		resultadoFactura.setColumns(10);

		JLabel finalImporteLabel = new JLabel("Importe total");
		finalImporteLabel.setBounds(310, 205, 160, 18);
		finalImporteLabel.setFont(new Font("Candara", Font.BOLD, 14));
		finalImporteLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel porcentajePropinaLabel = new JLabel("% propina");
		porcentajePropinaLabel.setBounds(30, 205, 160, 18);
		porcentajePropinaLabel.setFont(new Font("Candara", Font.BOLD, 14));
		porcentajePropinaLabel.setHorizontalAlignment(SwingConstants.CENTER);

		porcentajePropinaTexto = new JTextField();
		porcentajePropinaTexto.setBounds(30, 234, 160, 30);
		porcentajePropinaTexto.setLocale(new Locale("es", "ES"));
		porcentajePropinaTexto.setEditable(false);
		porcentajePropinaTexto.setHorizontalAlignment(SwingConstants.RIGHT);
		porcentajePropinaTexto.setColumns(10);


		JComboBox desplegablePorcentajes = new JComboBox<String>();
		desplegablePorcentajes.setBounds(270, 60, 220, 30);

		desplegablePorcentajes.setMaximumRowCount(5);
		desplegablePorcentajes.setModel(new DefaultComboBoxModel(new String[] {"~ Seleccione aquí un porcentaje ~", "\tPropina del 5%", "\tPropina del 10%", "\tPropina del 15%", "\tPropina del 20%"}));


		desplegablePorcentajes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestionarAccionDesplegable(desplegablePorcentajes);
				try {
					gestionarAccionDesplegable(desplegablePorcentajes);
				} catch (NumberFormatException ex) {

				}
			}
		});


		entradaTextoImporte.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				try {

					//	comprobar si hay alguna opcion "válida" seleccionada
					if (desplegablePorcentajes.getSelectedIndex() > 0)  {
						//	ejecucion si primero eliges un porcentaje y luego escribes tu coste inicial
						//					desplegablePorcentajes.setSelectedItem(e);
						gestionarAccionDesplegable(desplegablePorcentajes);
					}else {
						//	nada, esperar. 
					}
				} catch (NumberFormatException exc) {
					entradaTextoImporte.setText("Introduce un valor numérico.");
					porcentajePropinaTexto.setText("");
					resultadoFactura.setText("");
				}
			}
		}); 


		JButton limpiarButton = new JButton("Clear");
		limpiarButton.setBounds(395, 126, 75, 35);
		limpiarButton.setFont(UIManager.getFont("Button.font"));
		limpiarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		limpiarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entradaTextoImporte.setText("");
				porcentajePropinaTexto.setText("");
				resultadoFactura.setText("");
				desplegablePorcentajes.setSelectedIndex(0);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(peticionImporteLabel);
		contentPane.add(propinasLabel);
		contentPane.add(limpiarButton);
		contentPane.add(porcentajePropinaLabel);
		contentPane.add(entradaTextoImporte);
		contentPane.add(desplegablePorcentajes);
		contentPane.add(finalImporteLabel);
		contentPane.add(porcentajePropinaTexto);
		contentPane.add(resultadoFactura);


	}
}
