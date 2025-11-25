package view;

import controller.ControllerExame;
import model.Exame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaExame extends JFrame {

    private JTextField tId, tNome, tTipo, tStatus, tHoraI, tHoraF;
    private JTextArea tOrientacao;

    private JTable tabela;

    ControllerExame controller = new ControllerExame();

    public TelaExame() {
        setTitle("Cadastro de Exames");
        setSize(700, 500);
        setLayout(null);

        JLabel l1 = new JLabel("ID:");
        l1.setBounds(20, 20, 80, 25);
        add(l1);

        tId = new JTextField();
        tId.setBounds(100, 20, 100, 25);
        add(tId);

        JLabel l2 = new JLabel("Nome:");
        l2.setBounds(20, 60, 80, 25);
        add(l2);

        tNome = new JTextField();
        tNome.setBounds(100, 60, 200, 25);
        add(tNome);

        JLabel l3 = new JLabel("Tipo:");
        l3.setBounds(20, 100, 80, 25);
        add(l3);

        tTipo = new JTextField();
        tTipo.setBounds(100, 100, 50, 25);
        add(tTipo);

        JLabel l4 = new JLabel("Status:");
        l4.setBounds(20, 140, 80, 25);
        add(l4);

        tStatus = new JTextField();
        tStatus.setBounds(100, 140, 50, 25);
        add(tStatus);

        JLabel l5 = new JLabel("Orientação:");
        l5.setBounds(20, 180, 100, 25);
        add(l5);

        tOrientacao = new JTextArea();
        tOrientacao.setBounds(100, 180, 250, 80);
        add(tOrientacao);

        JLabel l6 = new JLabel("Hora início:");
        l6.setBounds(370, 20, 80, 25);
        add(l6);

        tHoraI = new JTextField();
        tHoraI.setBounds(450, 20, 80, 25);
        add(tHoraI);

        JLabel l7 = new JLabel("Hora fim:");
        l7.setBounds(370, 60, 80, 25);
        add(l7);

        tHoraF = new JTextField();
        tHoraF.setBounds(450, 60, 80, 25);
        add(tHoraF);

        JButton bSalvar = new JButton("Salvar");
        bSalvar.setBounds(370, 140, 150, 30);
        add(bSalvar);

        bSalvar.addActionListener(e -> salvar());

        tabela = new JTable();
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 280, 640, 150);
        add(scroll);

        carregarTabela();

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void salvar() {
        Exame ex = new Exame();

        ex.setExame_id(Integer.parseInt(tId.getText()));
        ex.setExame_nome(tNome.getText());
        ex.setExame_tipo(tTipo.getText());
        ex.setExame_status(tStatus.getText());
        ex.setExame_orientacao(tOrientacao.getText());
        ex.setExame_horai(tHoraI.getText());
        ex.setExame_horaf(tHoraF.getText());

        controller.cadastrar(ex);
        carregarTabela();
        JOptionPane.showMessageDialog(this, "Exame cadastrado!");
    }

    private void carregarTabela() {
        List<Exame> lista = controller.listar();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Tipo");
        model.addColumn("Status");
        model.addColumn("Início");
        model.addColumn("Fim");

        for (Exame e : lista) {
            model.addRow(new Object[]{
                    e.getExame_id(),
                    e.getExame_nome(),
                    e.getExame_tipo(),
                    e.getExame_status(),
                    e.getExame_horai(),
                    e.getExame_horaf()
            });
        }

        tabela.setModel(model);
    }
}
