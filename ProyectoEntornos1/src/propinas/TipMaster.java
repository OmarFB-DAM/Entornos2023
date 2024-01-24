package propinas;

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
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.event.CaretListener;
import javax.swing.text.NumberFormatter;
import javax.swing.event.CaretEvent;
import java.awt.SystemColor;

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
				if (input.matches("\\d+")) {
					entradaTextoImporte.setText("Utiliza la coma española \",\"");
					porcentajePropinaTexto.setText("Error");
					resultadoFactura.setText("Error");
				} else {
					entradaTextoImporte.setText("Introduce un valor numérico.");
					porcentajePropinaTexto.setText("Error");
					resultadoFactura.setText("Error");
				}
			}
		}
}

	public boolean esUnDouble(String input) {
		return input.matches("\\d+(\\,\\d+)?");
	}

	/**
	 * Create the frame.
	 */
	public TipMaster() {
		Locale locale = new Locale("es", "ES");
		Locale.setDefault(locale); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel peticion⁪ImporteLabel = new JLabel("Ingrese el importe de su factura.");
		peticion⁪ImporteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		peticion⁪ImporteLabel.setBounds(10, 20, 219, 14);
		contentPane.add(peticion⁪ImporteLabel);

		//entradaTextoImporte = new JFormattedTextField(new NumberFormatter(new DecimalFormat("###,###.##")));
		entradaTextoImporte = new JTextField();
		entradaTextoImporte.setHorizontalAlignment(SwingConstants.RIGHT);
		entradaTextoImporte.setBounds(30, 40, 160, 30);
		contentPane.add(entradaTextoImporte);
		entradaTextoImporte.setColumns(10);

		JLabel propinasLabel = new JLabel("Selector de propinas");
		propinasLabel.setHorizontalAlignment(SwingConstants.CENTER);
		propinasLabel.setBounds(228, 20, 180, 14);
		contentPane.add(propinasLabel);

		resultadoFactura = new JTextField();
		resultadoFactura.setEditable(false);
		resultadoFactura.setHorizontalAlignment(SwingConstants.RIGHT);
		resultadoFactura.setBounds(248, 160, 160, 30);
		contentPane.add(resultadoFactura);
		resultadoFactura.setColumns(10);

		JLabel finalImporteLabel = new JLabel("Importe total");
		finalImporteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalImporteLabel.setBounds(248, 140, 160, 14);
		contentPane.add(finalImporteLabel);

		JLabel porcentajePropinaLabel = new JLabel("% propina");
		porcentajePropinaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		porcentajePropinaLabel.setBounds(30, 140, 160, 14);
		contentPane.add(porcentajePropinaLabel);

		porcentajePropinaTexto = new JTextField();
		porcentajePropinaTexto.setEditable(false);
		porcentajePropinaTexto.setHorizontalAlignment(SwingConstants.RIGHT);
		porcentajePropinaTexto.setBounds(30, 160, 160, 30);
		contentPane.add(porcentajePropinaTexto);
		porcentajePropinaTexto.setColumns(10);


		JComboBox desplegablePorcentajes = new JComboBox<String>();

		desplegablePorcentajes.setMaximumRowCount(5);
		desplegablePorcentajes.setModel(new DefaultComboBoxModel(new String[] {"~ Seleccione aquí un porcentaje ~", "Propina del 5%", "Propina del 10%", "Propina del 15%", "Propina del 20%"}));
		desplegablePorcentajes.setBounds(228, 40, 180, 30);
		contentPane.add(desplegablePorcentajes);


		desplegablePorcentajes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestionarAccionDesplegable(desplegablePorcentajes);
				try {
				gestionarAccionDesplegable(desplegablePorcentajes);
				} catch (Exception ex) {
					
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
				} catch (Exception exc) {
					
				}
			}
		}); 

		
		JButton limpiarButton = new JButton("Limpiar selecciones");
		limpiarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entradaTextoImporte.setText("");
				porcentajePropinaTexto.setText("");
				resultadoFactura.setText("");
				desplegablePorcentajes.setSelectedIndex(0);
			}
		});
		limpiarButton.setBounds(248, 205, 160, 30);
		contentPane.add(limpiarButton);


	}
}
