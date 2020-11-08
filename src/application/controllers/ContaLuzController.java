package application.controllers;

import java.sql.Date;

import application.models.Cliente;
import application.models.ContaLuz;
import application.models.dao.ClienteSQL;
import application.models.dao.ContaLuzSQL;
import application.util.TextFieldFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ContaLuzController {

    @FXML
    private TextField txtNumeroIdentificacao;

    @FXML
    private TextField txtNomeTitular;

    @FXML
    private TextField txtDiasFatura;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtValorLeituraAtual;

    @FXML
    private Button botaoLimparCamposLuz;

    @FXML
    private TextField txtTensaoNominal;

    @FXML
    private TextField txtComplemento;

    @FXML
    private TextField txtMedidor;

    @FXML
    private TextField txtBandeiraTarifaria;

    @FXML
    private BorderPane btnContaAgua;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtTotalPagar;

    @FXML
    private TextField txtCodIdentificacaoConta;
    
    @FXML
    private TextField txtValorLeituraAnterior;
    
    @FXML
    private TextField txtTpFornecimento;

    @FXML
    private TextField txtConsumo;

    @FXML
    private DatePicker txtDataLeituraAtual;

    @FXML
    private TextField txtContaMes;

    @FXML
    private TextField txtGrupoSubgrupo;

    @FXML
    private TextField txtRua;

    @FXML
    private TextField txtClasseSubclasse;

    @FXML
    private TextField txtModTarifaria;

    @FXML
    private TextField txtUf;

    @FXML
    private TextField txtCep;

    @FXML
    private DatePicker txtDataLeituraAnterior;

    @FXML
    private TextField txtBairro;

    @FXML
    private DatePicker txtDataVencimento;
    
    @FXML
    private void txtCepKeyReleased() {

    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("#####-###");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtCep);
    	tff.formatter();
    }
    
    
    @FXML
    void clickLimpar(ActionEvent event) {
    	txtNumeroIdentificacao.setText("");
    	txtNomeTitular.setText("");
    	txtUf.setText("");
    	txtCidade.setText("");
    	txtBairro.setText("");
    	txtRua.setText("");
    	txtNumero.setText("");
    	txtComplemento.setText("");
    	txtCep.setText("");
    	txtGrupoSubgrupo.setText("");
    	txtTpFornecimento.setText("");
    	txtModTarifaria.setText("");
    	txtClasseSubclasse.setText("");
    	txtTensaoNominal.setText("");
    	txtMedidor.setText("");
    	txtCodIdentificacaoConta.setText("");
    	txtContaMes.setText("");
    	txtBandeiraTarifaria.setText("");
    	txtDiasFatura.setText("");
    	txtConsumo.setText("");
    	txtValorLeituraAtual.setText("");
    	txtValorLeituraAnterior.setText("");
    	txtDataLeituraAtual.setValue(null);
    	txtDataLeituraAnterior.setValue(null);
    	txtDataVencimento.setValue(null);
    	txtTotalPagar.setText("");
    }
    
    @FXML
    void clickEditar(ActionEvent event) {
    	
    }
    
    @FXML
    void clickCadastrar(ActionEvent event) {
    	int cod_identif_contaluz = Integer.parseInt(txtCodIdentificacaoConta.getText());
    	String grupo_subgrupo_contaluz = txtGrupoSubgrupo.getText();
    	String tpfornecimento_contaluz = txtTpFornecimento.getText();
    	String modtarifaria_contluz = txtModTarifaria.getText();
    	String rotleitura_contluz = "";
    	String codfiscal_contaluz = "";
    	String classe_subclasse_contaluz = txtClasseSubclasse.getText();
    	String tensaonominal_contaluz = txtTensaoNominal.getText();
    	int medidor_contaluz = Integer.parseInt(txtMedidor.getText());
    	float valortotal_contaluz = Float.parseFloat(txtTotalPagar.getText());
    	int numeroinstalacao_contaluz = Integer.parseInt(txtNumeroIdentificacao.getText());
    	int consumo_contluz = Integer.parseInt(txtConsumo.getText());
    	Date datavenc_contaluz = Date.valueOf(txtDataVencimento.getValue());
    	String contames_contaluz = txtContaMes.getText();
    	String bandtarifarias = txtBandeiraTarifaria.getText();
    	Date emissao_contaluz = null;
    	Date leituraanterior_contaluz = Date.valueOf(txtDataLeituraAnterior.getValue());
    	Date leituraatual_contaluz = Date.valueOf(txtDataLeituraAtual.getValue());
    	Date prevproxleit_contaluz = null;
    	int diasfatura_contaluz = Integer.parseInt(txtDiasFatura.getText());
    	String avisos_contaluz = "";
    	float leit_ant_contaluz = Float.parseFloat(txtValorLeituraAnterior.getText());
    	float leit_atual_contaluz = Float.parseFloat(txtValorLeituraAtual.getText());
    	float const_mult_contaluz = 0;
    	
    	
    	
    	ContaLuz contaluz = new ContaLuz(0, 1, cod_identif_contaluz, grupo_subgrupo_contaluz,
    			tpfornecimento_contaluz, modtarifaria_contluz, rotleitura_contluz,
    			codfiscal_contaluz, classe_subclasse_contaluz, tensaonominal_contaluz,
    			medidor_contaluz, 1, valortotal_contaluz,
    			numeroinstalacao_contaluz, consumo_contluz, datavenc_contaluz, contames_contaluz,
    			bandtarifarias, emissao_contaluz, leituraanterior_contaluz, leituraatual_contaluz,
    			prevproxleit_contaluz, diasfatura_contaluz, avisos_contaluz, leit_ant_contaluz,
    			leit_atual_contaluz, const_mult_contaluz);
    	ContaLuzSQL contaluzSQL = new ContaLuzSQL();
    	contaluzSQL.create(contaluz);

    }

    @FXML
    void clickBuscarCliente(ActionEvent event) {
    	ClienteSQL clienteSQL = new ClienteSQL();
    	Cliente cliente = clienteSQL.buscarClientePeloNome(txtNomeTitular.getText());
    	txtNomeTitular.setText(cliente.nome_cli);
    	txtCep.setText(cliente.getCep_cli());
    	txtUf.setText(cliente.estado_cli);
    	txtCidade.setText(cliente.cidade_cli);
    	txtComplemento.setText(cliente.complemento_cli);
    	txtBairro.setText(cliente.bairro_cli);
    	txtRua.setText(cliente.rua_cli);
    	txtNumero.setText(String.valueOf(cliente.numero_cli));
    }
}
