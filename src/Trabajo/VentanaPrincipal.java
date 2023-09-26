package Trabajo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private ListaPersonas lista;

    private Container contenedor;

    private JLabel nombre,apellidos,telefono,direccion;

    private JTextField campoNombre,campoApellidos,campoTelefono,campoDireccion;

    private JButton agregar,eliminar , borrarLista;

    private JList listaNombres;

    private DefaultListModel modelo;

    private JScrollPane scrollLista;


    //Metodo constructor
    public VentanaPrincipal() {

        lista = new ListaPersonas();
        inicio();
        setTitle("Trabajadores");
        setSize(270,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nombre=new JLabel();
        nombre.setText("Nombre:");
        nombre.setBounds(20,20,135,23);
        campoNombre=new JTextField();
        campoNombre.setBounds(100,20,135,23);

        apellidos=new JLabel();
        apellidos.setText("Apellidos:");
        apellidos.setBounds(20,50,135,23);
        campoApellidos=new JTextField();
        campoApellidos.setBounds(100,50,135,23);


        telefono=new JLabel();
        telefono.setText("Telefono:");
        telefono.setBounds(20,80,135,23);
        campoTelefono=new JTextField();
        campoTelefono.setBounds(100,80,135,23);


        direccion=new JLabel();
        direccion.setText("Direccion:");
        direccion.setBounds(20,110,135,23);
        campoDireccion=new JTextField();
        campoDireccion.setBounds(100,110,135,23);


        agregar=new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(100,150,80,23);
        agregar.addActionListener(this);

        eliminar=new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(20,280,80,23);
        eliminar.addActionListener(this);

        borrarLista=new JButton();
        borrarLista.setText("Borrar Lista");
        borrarLista.setBounds(120,280,120,23);
        borrarLista.addActionListener(this);

        listaNombres=new JList();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel();

        scrollLista = new JScrollPane();
        scrollLista.setBounds(20,190,220,80);
        scrollLista.setViewportView(listaNombres);

        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(telefono);
        contenedor.add(campoTelefono);
        contenedor.add(direccion);
        contenedor.add(campoDireccion);
        contenedor.add(agregar);
        contenedor.add(eliminar);
        contenedor.add(borrarLista);
        contenedor.add(scrollLista);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource()==agregar) {
            agregarPersona();
        }

        if(evento.getSource()==eliminar) {
            eliminarNombre(listaNombres.getSelectedIndex());

        }if(evento.getSource()==borrarLista) {
            borrarLista();
        }


    }




    private void agregarPersona( ) {
        Persona p = new Persona(campoNombre.getText(),campoApellidos.getText(),campoTelefono.getText(),campoDireccion.getText());
        lista.agregarPersona(p);

        String elemento="Nombre:"+campoNombre.getText()+
                "   ."+"Apellido:"+campoApellidos.getText();
        String elemento3="Telefono:"+campoTelefono.getText();
        String elemento4 ="Direccion:"+campoDireccion.getText();

        if(modelo.contains(elemento)) {

            JOptionPane.showMessageDialog(null,"El nombre y el apellido ya existe", "error" , JOptionPane.ERROR_MESSAGE);

        }
        else  {

            modelo.addElement(elemento);
            modelo.addElement(elemento3);
            modelo.addElement(elemento4);

            listaNombres.setModel(modelo);

            campoNombre.setText("");
            campoApellidos.setText("");
            campoTelefono.setText("");
            campoDireccion.setText("");
        }

    }

    private void eliminarNombre(int indice) {
        if(indice>=0) {
            modelo.removeElementAt(indice);
            lista.eliminarPersona(indice);

        }else {
            JOptionPane.showMessageDialog(null,"Debe seleccionar un elemento", "error" , JOptionPane.ERROR_MESSAGE);
        }
    }
    private void borrarLista() {
        lista.borrarLista();
        modelo.clear();
    }

}
