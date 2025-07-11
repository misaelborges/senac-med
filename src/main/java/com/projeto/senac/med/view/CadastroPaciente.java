/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.projeto.senac.med.view;

import com.projeto.senac.med.dao.EnderecoDAO;
import com.projeto.senac.med.dao.PacienteDAO;
import com.projeto.senac.med.dao.TelefoneDAO;
import com.projeto.senac.med.exception.NegocioException;
import com.projeto.senac.med.model.Endereco;
import com.projeto.senac.med.model.Paciente;
import com.projeto.senac.med.model.Telefone;
import com.projeto.senac.med.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author suzan
 */
public class CadastroPaciente extends javax.swing.JFrame {

    /**
     * Creates new form CadastroPaciente
     */
    private final Connection connection = Conexao.conectar();

    public CadastroPaciente() {
        initComponents();
        setResizable(false);
        configurarTeclaEnter();
    }

    private void configurarTeclaEnter() {
        txtNomePaciente.addActionListener(e -> txtCpf.requestFocusInWindow());
        txtCpf.addActionListener(e -> txtDataNasc.requestFocusInWindow());
        txtDataNasc.addActionListener(e -> txtEndereco.requestFocusInWindow());
        txtEndereco.addActionListener(e -> txtBairro.requestFocusInWindow());
        txtBairro.addActionListener(e -> txtComplemento.requestFocusInWindow());
        txtComplemento.addActionListener(e -> txtNumero.requestFocusInWindow());
        txtNumero.addActionListener(e -> txtCep.requestFocusInWindow());
        txtCep.addActionListener(e -> txtCidade.requestFocusInWindow());
        txtCidade.addActionListener(e -> txtEstado.requestFocusInWindow());
        txtEstado.addActionListener(e -> txtCelular.requestFocusInWindow());
        txtCelular.addActionListener(e -> comboBoxTipoTelefone.requestFocusInWindow());
        comboBoxTipoTelefone.addActionListener(e -> txtContato2.requestFocusInWindow());
        txtContato2.addActionListener(e -> comboBoxTipoTelefone2.requestFocusInWindow());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Painelpaciente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        lblDataNasci = new javax.swing.JLabel();
        txtDataNasc = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        lblLogradouro = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblTelefone1 = new javax.swing.JLabel();
        lblTipo1 = new javax.swing.JLabel();
        comboBoxTipoTelefone = new javax.swing.JComboBox<>();
        lblTelefone2 = new javax.swing.JLabel();
        lblTipo2 = new javax.swing.JLabel();
        comboBoxTipoTelefone2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtContato2 = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JFormattedTextField();
        txtEstado = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Painelpaciente.setBackground(new java.awt.Color(255, 255, 255));
        Painelpaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro Paciente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        Painelpaciente.setPreferredSize(new java.awt.Dimension(800, 600));
        Painelpaciente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome completo");
        Painelpaciente.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 111, -1));

        txtNomePaciente.setBackground(java.awt.Color.white);
        txtNomePaciente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNomePaciente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePacienteActionPerformed(evt);
            }
        });
        Painelpaciente.add(txtNomePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 353, -1));

        txtCpf.setBackground(java.awt.Color.white);
        txtCpf.setForeground(new java.awt.Color(60, 63, 65));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        Painelpaciente.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 100, -1));

        lblCPF.setText("CPF");
        Painelpaciente.add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 33, -1));

        lblDataNasci.setText("Data de Nascimento: ");
        Painelpaciente.add(lblDataNasci, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 114, -1));

        txtDataNasc.setBackground(java.awt.Color.white);
        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascActionPerformed(evt);
            }
        });
        Painelpaciente.add(txtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 77, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Dados gerais ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 12))); // NOI18N

        lblLogradouro.setText("Endereço");

        lblBairro.setText("Bairro");

        lblCidade.setText("Cidade");

        lblCEP.setText("CEP");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        lblNumero.setText("N");

        lblEstado.setText("Estado");

        lblTelefone1.setText("Telefone 1");

        lblTipo1.setText("Tipo");

        comboBoxTipoTelefone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celular", "Whatsapp" }));
        comboBoxTipoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoTelefoneActionPerformed(evt);
            }
        });

        lblTelefone2.setText("Telefone 2");

        lblTipo2.setText("Tipo");

        comboBoxTipoTelefone2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fixo", " " }));

        jLabel4.setText("Complemento");

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        try {
            txtContato2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        try {
            txtEstado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo2)
                            .addComponent(lblTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxTipoTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCEP)
                        .addGap(18, 18, 18)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(lblCidade)
                        .addGap(18, 18, 18)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNumero)
                            .addComponent(lblBairro))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(254, 254, 254))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTelefone1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTelefone2)
                        .addGap(18, 18, 18)
                        .addComponent(txtContato2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogradouro)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBairro)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNumero))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(lblCidade)
                    .addComponent(lblCEP))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone1)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone2)
                    .addComponent(txtContato2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTipoTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo2))
                .addGap(56, 56, 56))
        );

        Painelpaciente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 720, 320));

        btnSalvar.setBackground(new java.awt.Color(204, 204, 204));
        btnSalvar.setText("Cadastrar ");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        Painelpaciente.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 500, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        Painelpaciente.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, -1, -1));

        getContentPane().add(Painelpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNomePaciente.setText("");
        txtCpf.setText("");
        txtDataNasc.setText("");
        txtComplemento.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtBairro.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtCelular.setText("");

        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtNomePaciente.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtCpf.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo CPF não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtDataNasc.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Data de Nascimento não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtCep.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo CEP não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtEstado.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Estado não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtCidade.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Cidade não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtBairro.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Bairro não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtEndereco.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Logradouro não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtNumero.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Número não pode estar vazio!", "Atenção", 0);
            return;
        }
        if (txtCelular.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O Campo Telefone não pode estar vazio!", "Atenção", 0);
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

        try {
            connection.setAutoCommit(false);

            //paciente
            String nome = txtNomePaciente.getText();
            String cpfComMascara = txtCpf.getText();
            String dataStr = txtDataNasc.getText().trim();

            LocalDate dataNacimento;

            try {
                dataNacimento = LocalDate.parse(dataStr, formatter);
                if (dataNacimento.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, "A data de nascimento não pode ser no futuro", "Atenção", 0);
                    return;
                }

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Atenção", 0);
                e.printStackTrace();
                return;
            }

            String cpf = cpfComMascara.replaceAll("[^\\d]", ""); // remove tudo oque não for numero
            Paciente paciente = new Paciente(nome, cpf, dataNacimento);

            PacienteDAO pacienteDAO = new PacienteDAO(connection);
            pacienteDAO.salvar(paciente);

            //endereço
            String cepComMascara = txtCep.getText();
            String cep = cepComMascara.replaceAll("[^\\d]", "");
            String estado = txtEstado.getText();
            String cidade = txtCidade.getText();
            String bairro = txtBairro.getText();
            String logradouro = txtEndereco.getText();
            Integer numero = Integer.valueOf(txtNumero.getText());

            Endereco endereco = new Endereco();
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setEstado(estado.toUpperCase());
            endereco.setCep(cep);
            endereco.setIdpaciente(paciente.getId());

            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
            enderecoDAO.salvar(endereco);

            //telefone
            String numeroTelefone = txtCelular.getText();
            String numeroTelefone2 = txtContato2.getText();

            DefaultComboBoxModel tiposTelefone = (DefaultComboBoxModel) this.comboBoxTipoTelefone.getModel();
            DefaultComboBoxModel tiposTelefone2 = (DefaultComboBoxModel) this.comboBoxTipoTelefone2.getModel();

            String tipoTelefone = tiposTelefone.getSelectedItem().toString();
            String tipoTelefone2 = tiposTelefone2.getSelectedItem().toString();

            Telefone telefone = new Telefone();
            telefone.setNumero(numeroTelefone);
            telefone.setTipoTelefone(tipoTelefone.toUpperCase());
            telefone.setIdPaciente(paciente.getId());

            Telefone telefone2 = new Telefone();
            telefone2.setNumero(numeroTelefone2);
            telefone2.setTipoTelefone(tipoTelefone2.toUpperCase());
            telefone2.setIdPaciente(paciente.getId());

            TelefoneDAO telefoneDAO = new TelefoneDAO(connection);
            telefoneDAO.salvar(telefone);
            telefoneDAO.salvar(telefone2);

            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");

            connection.commit();

            txtNomePaciente.setText("");
            txtCpf.setText("");
            txtDataNasc.setText("");
            txtCep.setText("");
            txtEstado.setText("");
            txtCidade.setText("");
            txtBairro.setText("");
            txtEndereco.setText("");
            txtNumero.setText("");
            txtCelular.setText("");
            txtContato2.setText("");

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.getLogger(CadastroPaciente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            throw new NegocioException("Houve algum erro durante o processamento de dados, entre em contato com o suporte", e);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void comboBoxTipoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoTelefoneActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePacienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painelpaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxTipoTelefone;
    private javax.swing.JComboBox<String> comboBoxTipoTelefone2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblDataNasci;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTelefone1;
    private javax.swing.JLabel lblTelefone2;
    private javax.swing.JLabel lblTipo1;
    private javax.swing.JLabel lblTipo2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtContato2;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtEstado;
    private javax.swing.JTextField txtNomePaciente;
    private javax.swing.JFormattedTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
