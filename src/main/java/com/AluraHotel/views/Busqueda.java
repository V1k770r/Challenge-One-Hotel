package com.AluraHotel.views;

import com.AluraHotel.controlador.HuespedControlador;
import com.AluraHotel.controlador.ReservasControlador;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.NumericUtilitario;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static com.AluraHotel.views.ReservasView.txtFechaEntrada;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private ReservasControlador reservasControlador = new ReservasControlador();
	private HuespedControlador huespedControlador = new HuespedControlador();

	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		cargarTablaReservas();

		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")),
				scroll_table, null);
		scroll_table.setVisible(true);


		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		cargarTablaHuespedes();
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NumericUtilitario validarNumero = new NumericUtilitario();
				if (validarNumero.isNumeric(txtBuscar.getText())) {
					limpiarTablaReservas();
					buscarIdReservas();
				} else {
					limpiarTablaHuespedes();
					buscarApellidoHuespedes();
				}
			}
		});

		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tbReservas.getSelectedRow();
				int filaHuespedes = tbHuespedes.getSelectedRow();

				if(filaReservas >=0) {
					ActualizarReservas();
					limpiarTablaReservas();
					cargarTablaReservas();
				}
				else if (filaHuespedes >=0){
					actualizarHuespedes();
					limpiarTablaReservas();
					cargarTablaReservas();
				}
			}
		});


//		btnEditar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				int filaReservas = tbReservas.getSelectedRow();
//				int filaHuespedes = tbHuespedes.getSelectedRow();

//				if (filaReservas > 0) {
//					String reserva = tbReservas.getValueAt(filaReservas, 0).toString();
//					int confirmar = JOptionPane.showConfirmDialog(null, "Deseas editar la reserva N° "
//							+ reserva + "?");
//
//					if (confirmar == JOptionPane.YES_OPTION) {
//						String valor1 = tbReservas.getValueAt(filaReservas, 0).toString();
//						System.out.println(valor1);
//						String valor2 = tbReservas.getValueAt(filaReservas, 1).toString();
//						String valor3 = tbReservas.getValueAt(filaReservas, 2).toString();
//						String valor4 = tbReservas.getValueAt(filaReservas, 3).toString();
//						String valor5 = tbReservas.getValueAt(filaReservas, 4).toString();
//
//						reservasControlador.editarTablaReserva(Integer.valueOf(valor1), valor2, valor3, valor4, valor5);
//						JOptionPane.showMessageDialog(contentPane, " la reserva N°  " + reserva + " fue  edita");
//
//						limpiarTablaReservas();
//						cargarTablaReservas();
//					}
//
//				} else if (filaHuespedes > 0) {
//					String huespedes = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
//					int confirmaH = JOptionPane.showConfirmDialog(null, "Desea editar el huesped N° " +
//							huespedes + "  ?");
//
//					if (confirmaH == JOptionPane.YES_OPTION) {
//						String valor1 = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
//
//						String valor2 = tbHuespedes.getValueAt(filaHuespedes,1).toString();
//						String valor3 = tbHuespedes.getValueAt(filaHuespedes,2).toString();
//						String valor4 = tbHuespedes.getValueAt(filaHuespedes,3).toString();
//						String valor5 = tbHuespedes.getValueAt(filaHuespedes,4).toString();
//						String valor6 = tbHuespedes.getValueAt(filaHuespedes,5).toString();
//						String valor7 = tbHuespedes.getValueAt(filaHuespedes,6).toString();
//
//						huespedControlador.editarTablaHuesped(Integer.valueOf(valor1),valor2,valor3,
//								valor4,valor5,valor6,Integer.valueOf(valor7));
//						JOptionPane.showMessageDialog(contentPane, "Reserva editada");
//
//						limpiarTablaHuespedes();
//						cargarTablaHuespedes();
//					}
//
//				} else {
//					JOptionPane.showMessageDialog(null, "Hubo un error, debe indicar que reserva " +
//							"o huesped desea editar");
//				}
//			}
//		});

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);


//		tbReservas.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent event){
//				int filaSeleccionada = tbReservas.getSelectedRow();
//				int columnaSeleccionada = 0;
//				Integer valorCelda = (Integer) tbReservas.getValueAt(filaSeleccionada,columnaSeleccionada);
//				System.out.println(valorCelda);
//			}
//		});

		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tbReservas.getSelectedRow();
				int filaHuespedes = tbHuespedes.getSelectedRow();

				if (filaReservas > 0) {
					String reserva = tbReservas.getValueAt(filaReservas, 0).toString();
					int confirmar = JOptionPane.showConfirmDialog(null, "Deseas borrar la reserva N° " + reserva + "?");

						if (confirmar == JOptionPane.YES_OPTION) {
							String valor = tbReservas.getValueAt(filaReservas, 0).toString();
							reservasControlador.eliminarRowbyId(Integer.valueOf(valor));
							JOptionPane.showMessageDialog(contentPane, " la reserva N°  " + reserva + " fue  borrada");

							limpiarTablaReservas();
							cargarTablaReservas();
							}

					} else if (filaHuespedes > 0) {
						String huespedes = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
						int confirmaH = JOptionPane.showConfirmDialog(null, "Desea borrar el huesped N° " + huespedes + " ?");

							if (confirmaH == JOptionPane.YES_OPTION) {
								String valor = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
								huespedControlador.EliminarHuespedById(Integer.valueOf(valor));
								JOptionPane.showMessageDialog(contentPane, "Reserva borrada");

							limpiarTablaHuespedes();
							cargarTablaHuespedes();
					}

					} else {
					JOptionPane.showMessageDialog(null, "Hubo un error, debe indicar que reserva o huesped desea eliminar");
					}
				}
		});


		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);

		//Centro los datos dentro de la tabla Reservas
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tbReservas.getColumnCount(); i++) {
			tbReservas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		//Centro los datos dentro de la tabla Huespedes
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tbHuespedes.getColumnCount(); i++) {
			tbHuespedes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer1);
		}
	}

	//metodo para cargar la tabla reservas
	private void cargarTablaReservas() {
		var reservas = this.reservasControlador.cargarReservas();
		reservas.forEach(reserva -> modelo.addRow(
				new Object[]{
						reserva.getId_reserva(),
						reserva.getFechaE(),
						reserva.getFechaS(),
						reserva.getValor(),
						reserva.getFormaDePago()}));
	}

	//metodo para buscar un elemento en la tabla reservas

	private void buscarIdReservas() {
		Integer nReserva = Integer.valueOf(txtBuscar.getText());
		var nnReserva = this.reservasControlador.buscarById(nReserva);
		nnReserva.forEach(reserva -> modelo.addRow(
				new Object[]{
						reserva.getId_reserva(),
						reserva.getFechaE(),
						reserva.getFechaS(),
						reserva.getValor(),
						reserva.getFormaDePago()
				}));
	}

	//metodo para cargar la tabla huespedes
	private void cargarTablaHuespedes() {
		var huespedes = this.huespedControlador.cargarHuespedes();
		huespedes.forEach(huesped -> modeloHuesped.addRow(
				new Object[]{
						huesped.getId_huesped(),
						huesped.getNombre(),
						huesped.getApellido(),
						huesped.getFechaDeNacimiento(),
						huesped.getNacionalidad(),
						huesped.getTelefono(),
						huesped.getReservas().getId_reserva()
				}));
	}

	//metodo para buscar un elemento en la tabla reservas
	private void buscarApellidoHuespedes() {
		String nApellido = txtBuscar.getText().trim();
		var nnApellido = this.huespedControlador.buscarByApellido(nApellido);
		nnApellido.forEach(huesped -> modeloHuesped.addRow(
				new Object[]{
						huesped.getId_huesped(),
						huesped.getNombre(),
						huesped.getApellido(),
						huesped.getFechaDeNacimiento(),
						huesped.getNacionalidad(),
						huesped.getTelefono(),
						huesped.getReservas().getId_reserva()
				}));
	}

	private void ActualizarReservas() {
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila ->{

					LocalDate fechaE = LocalDate.parse((modelo.getValueAt(tbReservas.getSelectedRow(),1 ).toString()));
					LocalDate fechaS = LocalDate.parse(modelo.getValueAt(tbReservas.getSelectedRow(),2 ).toString());
					String valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
					String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
					Integer id = Integer.valueOf((modelo.getValueAt(tbReservas.getSelectedRow(),0 ).toString()));

					this.reservasControlador.editarTablaReserva (fechaE, fechaS, valor, formaPago,id);

					JOptionPane.showMessageDialog(this, String.format("Registro Modificado con exito"));

				}, ()-> JOptionPane.showMessageDialog(this, "Falto cambiar el valor!!!"));
	}

	private void actualizarHuespedes() {
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
				.ifPresentOrElse(filaHuespedes ->{


					Integer id_huesped= Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),0).toString());
					String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
					String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
					LocalDate fechaNacimiento = LocalDate.parse(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),3 ).toString());
					String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
					String telefono = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5);
					Integer id_reserva = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),6).toString());


					this.huespedControlador.editarTablaHuesped (id_huesped, nombre, apellido, fechaNacimiento, nacionalidad, telefono,id_reserva);
					JOptionPane.showMessageDialog(this, String.format("Registro Modificado con exito"));

				}, ()-> JOptionPane.showMessageDialog(this, "Falta indicar valor a editar"));

	}











	//ocultar tabla principal al realizar la busqueda de una reserva
	private void limpiarTablaReservas() {
		modelo.getDataVector().clear();
	}

	//ocultar tabla principal al realizar la busqueda de un huesped
	private void limpiarTablaHuespedes() {
		modeloHuesped.getDataVector().clear();
	}


//	private void eliminarTabla() {
//		((DefaultTableModel) tbHuespedes.getModel()).setRowCount(0);
//		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
//	}


//	private void mostrarTablaReservas() {
//		List<ReservasEntity> reservas = buscarReservas();
//		try {
//			for (ReservasEntity res : reservas) {
//				modelo.addRow(new Object[]{
//						res.getId_reserva(),
//						res.getFechaE(),
//						res.getFechaS(),
//						res.getValor(),
//						res.getFormaDePago()
//				});
//			}
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//
//
//



//
//		}
//
//	private void editarTabla(){
//
//		this.reservasControlador.editarTablaReserva();
//
//	}








		//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
		private void headerMousePressed (MouseEvent evt){
			xMouse = evt.getX();
			yMouse = evt.getY();
		}

		private void headerMouseDragged (MouseEvent evt){
			int x = evt.getXOnScreen();
			int y = evt.getYOnScreen();
			this.setLocation(x - xMouse, y - yMouse);
		}


}

