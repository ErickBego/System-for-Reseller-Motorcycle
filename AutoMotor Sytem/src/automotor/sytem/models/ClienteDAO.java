/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automotor.sytem.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jcodogno
 */
public class ClienteDAO{
    
    private String nomeCompleto;
    private int ID;
    private int TPessoa;
    private int TCliente;
    private String CNPJCPF;
    private String IERG;
    private String DocEstr;
    private String Suframa;
    private int Sexo;
    private String Data;
    private String TelResiden;
    private String TelComercial;
    private String TelCelular;
    private String CEP;
    private String Street;
    private String Num;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String Email;
    private String Contato;
    private String WebSite;
    private String Observacao;
    private boolean ativo;
    
    public String getEmail() {
        return Email;
    }

    public ClienteDAO setEmail(String Email) {
        this.Email = Email;
        return this;
    }

    public String getContato() {
        return Contato;
    }

    public ClienteDAO setContato(String Contato) {
        this.Contato = Contato;
        return this;
    }

    public String getWebSite() {
        return WebSite;
    }

    public ClienteDAO setWebSite(String WebSite) {
        this.WebSite = WebSite;
        return this;
    }

    public String getObservacao() {
        return Observacao;
    }

    public ClienteDAO setObservacao(String Observacao) {
        this.Observacao = Observacao;
        return this;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public ClienteDAO setAtivo(boolean ativo) {
        this.ativo = ativo;
        return this;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public ClienteDAO setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public int getID() {
        return ID;
    }

    public ClienteDAO setID(int ID) {
        this.ID = ID;
        return this;
    }

    public int getTPessoa() {
        return TPessoa;
    }

    public ClienteDAO setTPessoa(int TPessoa) {
        this.TPessoa = TPessoa;
        return this;
    }

    public int getTCliente() {
        return TCliente;
    }

    public ClienteDAO setTCliente(int TCliente) {
        this.TCliente = TCliente;
        return this;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    public ClienteDAO setCNPJCPF(String CNPJCPF) {
        this.CNPJCPF = CNPJCPF;
        return this;
    }

    public String getIERG() {
        return IERG;
    }

    public ClienteDAO setIERG(String IERG) {
        this.IERG = IERG;
        return this;
    }

    public String getDocEstr() {
        return DocEstr;
    }

    public ClienteDAO setDocEstr(String DocEstr) {
        this.DocEstr = DocEstr;
        return this;
    }

    public String getSuframa() {
        return Suframa;
    }

    public ClienteDAO setSuframa(String Suframa) {
        this.Suframa = Suframa;
        return this;
    }

    public int getSexo() {
        return Sexo;
    }

    public ClienteDAO setSexo(int Sexo) {
        this.Sexo = Sexo;
        return this;
    }

    public String getData() {
        return Data;
    }

    public ClienteDAO setData(String Data) {
        this.Data = Data;
        return this;
    }

    public String getTelResiden() {
        return TelResiden;
    }

    public ClienteDAO setTelResiden(String TelResiden) {
        this.TelResiden = TelResiden;
        return this;
    }

    public String getTelComercial() {
        return TelComercial;
    }

    public ClienteDAO setTelComercial(String TelComercial) {
        this.TelComercial = TelComercial;
        return this;
    }

    public String getTelCelular() {
        return TelCelular;
    }

    public ClienteDAO setTelCelular(String TelCelular) {
        this.TelCelular = TelCelular;
        return this;
    }

    public String getCEP() {
        return CEP;
    }

    public ClienteDAO setCEP(String CEP) {
        this.CEP = CEP;
        return this;
    }

    public String getStreet() {
        return Street;
    }

    public ClienteDAO setStreet(String Street) {
        this.Street = Street;
        return this;
    }

    public String getNum() {
        return Num;
    }

    public ClienteDAO setNum(String Num) {
        this.Num = Num;
        return this;
    }

    public String getBairro() {
        return Bairro;
    }

    public ClienteDAO setBairro(String Bairro) {
        this.Bairro = Bairro;
        return this;
    }

    public String getCidade() {
        return Cidade;
    }

    public ClienteDAO setCidade(String Cidade) {
        this.Cidade = Cidade;
        return this;
    }

    public String getEstado() {
        return Estado;
    }

    public ClienteDAO setEstado(String Estado) {
        this.Estado = Estado;
        return this;
    }
    
            
    public ClienteDAO(){
    }
    
    public void consultaCliente(int id) throws SQLException{
        String sql = "SELECT * as qtd FROM clientes WHERE idClientes="+id;
        ResultSet rs;
        try (Connection conn = ConnectionMySql.startConnection()) {
            PreparedStatement comando = conn.prepareStatement(sql);
            rs = comando.executeQuery();
        }
        
    }

    public int numQtd() throws SQLException{
        String sql = "SELECT COUNT(*) as qtd FROM clientes";
        ResultSet rs;
        Connection conn = ConnectionMySql.startConnection();
        PreparedStatement comando = conn.prepareStatement(sql);
        rs = comando.executeQuery();
        boolean next = rs.next();
        return rs.getInt("qtd");
    }

    public void salvar() throws SQLException, ParseException {
        String sql = "INSERT INTO clientes (`NomeRazao`, `Datacadastro`, `DataAtualizacao`, `TipoCliente`, `CpfCnpj`, `IERG`, `TipoPessoa`, `DocEstrangeiro`, `DataNascimento`, `TelefoneResidencial`, `TelefoneComercial`, `NumeroInscricaoSuframa`, `Celular`, `Contato`, `Email`, `Website`, `Observacao`, `Ativo`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs;
        try (Connection conn = ConnectionMySql.startConnection()) {
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, this.nomeCompleto);
            java.util.Date dataUtil = new java.util.Date();
            preparedStmt.setDate(2, new java.sql.Date(dataUtil.getTime()));
            preparedStmt.setDate(3, new java.sql.Date(dataUtil.getTime()));
            preparedStmt.setInt(4, this.TCliente);
            preparedStmt.setString(5, this.CNPJCPF);
            preparedStmt.setString(6, this.IERG);
            preparedStmt.setInt(7, this.TPessoa);
            preparedStmt.setString(8, this.DocEstr);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            preparedStmt.setDate(9, new java.sql.Date(formato.parse(this.Data).getTime()));
            preparedStmt.setString(10, this.TelResiden);
            preparedStmt.setString(11, this.TelComercial);
            preparedStmt.setString(12, this.Suframa);
            preparedStmt.setString(13, this.TelCelular);
            preparedStmt.setString(14, this.Contato);
            preparedStmt.setString(15, this.Email);
            preparedStmt.setString(16, this.WebSite);
            preparedStmt.setString(17, this.Observacao);
            preparedStmt.setBoolean(18, this.ativo);
            preparedStmt.execute();
            conn.close();
        }
    }
}
