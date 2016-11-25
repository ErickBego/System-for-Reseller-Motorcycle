/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automotor.sytem.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jcodogno
 */
public class ClienteDAO extends AbstractDAO{
    
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
    private int ativo;
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String WebSite) {
        this.WebSite = WebSite;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTPessoa() {
        return TPessoa;
    }

    public void setTPessoa(int TPessoa) {
        this.TPessoa = TPessoa;
    }

    public int getTCliente() {
        return TCliente;
    }

    public void setTCliente(int TCliente) {
        this.TCliente = TCliente;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    public void setCNPJCPF(String CNPJCPF) {
        this.CNPJCPF = CNPJCPF;
    }

    public String getIERG() {
        return IERG;
    }

    public void setIERG(String IERG) {
        this.IERG = IERG;
    }

    public String getDocEstr() {
        return DocEstr;
    }

    public void setDocEstr(String DocEstr) {
        this.DocEstr = DocEstr;
    }

    public String getSuframa() {
        return Suframa;
    }

    public void setSuframa(String Suframa) {
        this.Suframa = Suframa;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getTelResiden() {
        return TelResiden;
    }

    public void setTelResiden(String TelResiden) {
        this.TelResiden = TelResiden;
    }

    public String getTelComercial() {
        return TelComercial;
    }

    public void setTelComercial(String TelComercial) {
        this.TelComercial = TelComercial;
    }

    public String getTelCelular() {
        return TelCelular;
    }

    public void setTelCelular(String TelCelular) {
        this.TelCelular = TelCelular;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String Num) {
        this.Num = Num;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
            
    public ClienteDAO(){
    }
    
    public void consultaCliente(){
        this.setTable("clientes").select("*");
    }

    public int numQtd() throws SQLException {
       ResultSet rs = this.setTable("clientes").select("COUNT(*) as qtd").getResult();
       boolean next = rs.next();
       return rs.getInt("qtd");
    }

    public void salvar() {
        ResultSet rs = this.setTable("clientes").;
    }
}
