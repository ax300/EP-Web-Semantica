import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static LinkedList<Cliente> listaClientes = new LinkedList<>();

    static void exibeCliente(){


        Iterator<Cliente> it =  listaClientes.iterator();

        while(it.hasNext()){

            System.out.println(it.next().nome);

        }
    }
    public static void main(String[] args) {

        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        model.read("E:\\Downloads\\centro_comercial\\Ontologia-CentroComercial.ttl");
        //model.write(System.out, "TTL");
        Query queryLoja = QueryFactory.create(

                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                        "PREFIX : <http://www.semanticweb.org/ax300/ontologies/2019/9/untitled-ontology-15#>\n" +

                        "SELECT DISTINCT  ?Nome_Loja ?Atividade ?Vende ?x ?Nome_Vende ?Preço_Vende " +
                        "WHERE {?x rdf:type :Lojas ." +
                        "?x :Nome_Loja ?Nome_Loja." +
                        "?x :Atividade ?Atividade." +
                        "?x :Vende ?Vende." +
                        "?Vende :Nome_Produto ?Nome_Vende." +
                        "?Vende :Preço ?Preço_Vende" +
                        "}"
        );



        Query queryCliente = QueryFactory.create(

                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                        "PREFIX : <http://www.semanticweb.org/ax300/ontologies/2019/9/untitled-ontology-15#>\n" +

                        "SELECT DISTINCT  ?Nome_Indivíduo ?Interesse ?Idade ?RG ?Sexo ?x " +
                        "WHERE {?x rdf:type :Cliente ." +
                        "?x :Nome_Indivíduo ?Nome_Indivíduo." +
                        "?x :Interesse ?Interesse." +
                        "?x :Idade ?Idade." +
                        "?x :RG ?RG." +
                        "?x :Sexo ?Sexo." +
                        "}"
        );





        QueryExecution queryExecutionLoja = QueryExecutionFactory.create(queryLoja, model);
        ResultSet resultSetLoja = queryExecutionLoja.execSelect();

        QueryExecution queryExecutionCliente = QueryExecutionFactory.create(queryCliente, model);
        ResultSet resultSetCliente = queryExecutionCliente.execSelect();




        System.out.println(resultSetCliente);

        while (resultSetCliente.hasNext()) {
            QuerySolution querySolution = resultSetCliente.next();

            String nomeIndividuo  = querySolution.getLiteral("?Nome_Indivíduo").getString();
            int idade = querySolution.getLiteral("?Idade").getInt();
            String sexo = querySolution.getLiteral("?Sexo").getString();
            int rg = querySolution.getLiteral("?RG").getInt();
            String interesse = querySolution.getLiteral("?Interesse").getString();


            Cliente cliente = new Cliente(nomeIndividuo,idade,rg,interesse,sexo);
            listaClientes.add(cliente);


            //System.out.println(querySolution);
        }



        while (resultSetLoja.hasNext()) {
            QuerySolution querySolution = resultSetLoja.next();
            System.out.println(querySolution);
            String nomeLoja  = querySolution.getLiteral("?Nome_Loja").getString();
            String atividade = querySolution.getLiteral("?Atividade").getString();

            //System.out.println(querySolution);
            //int idade = querySolution.getLiteral("idade").getInt();
            //Cliente cliente = new Cliente();
            //cliente.setNome(name);
            //cliente.setIdade(idade);
            //System.out.println("batata");
//             System.out.println(atividade);



            //System.out.println(querySolution);
        }



/*
"""
        PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
        PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
        PREFIX : <http://nemo.inf.ufes.br/OntoQSAR.owl#>

         SELECT DISTINCT ?Inhibitor_ID ?x
         WHERE {
            ?x rdf:type :atom_count.
            ?x :atom_count_value ?atom_count.
            ?y rdf:type :Chemical_Descriptor.
            ?y :sub_chemical_descriptor ?x.
            ?z :chemical_descriptor ?y.
            ?z :Inhibitor_ID ?Inhibitor_ID.
            FILTER (?atom_count < 45.0)
         }

    """
 */
        exibeCliente();


    }
}
