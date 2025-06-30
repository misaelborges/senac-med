/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import com.projeto.senac.med.dao.EspecialidadeDAO;
import com.projeto.senac.med.model.Especialidade;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Murialdo
 */
public class TesteBanco_SenacMed {

    @Test
    public void initBanco() {
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        Especialidade especialidade = new Especialidade();

        especialidade.setNome("Psiquiatria");
        especialidadeDAO.salvar(especialidade);
    }

    @Test
    public void initListar() {
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        try {
            List<Especialidade> list = especialidadeDAO.listar();
            for (Especialidade especialidade : list) {
                System.out.println(especialidade);
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Test
    public void initbuscar() {
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        try {
            Especialidade especialidade = especialidadeDAO.buscar(1L);
            System.out.println(especialidade);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void initAtualizar() {
        try {
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            Especialidade especialidade = especialidadeDAO.buscar(10L);

            especialidade.setNome("Especialidade com o nome atualizado");
            especialidadeDAO.atualizar(especialidade);

            System.out.println("Especialidade Atualizada com sucesso..!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void initDeletar() {
        try {
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            especialidadeDAO.deletar(10L);
            System.out.println("Especialidade Deletada com sucesso..!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
