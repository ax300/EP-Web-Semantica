import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        model.read("E:\\Downloads\\centro_comercial\\Ontologia-CentroComercial.ttl");
        //model.write(System.out, "TTL");
        Query query = QueryFactory.create(
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX : <http://www.semanticweb.org/ax300/ontologies/2019/9/untitled-ontology-15#>\n" +

//                        "SELECT DISTINCT ?Nome_Loja ?x " +
//                        "WHERE {?x rdf:type :Lojas ." +
//                        " ?x :Nome_Loja ?Nome_Loja.}"
                "SELECT DISTINCT ?Atividade ?x" +
                        "WHERE {?x rdf:type :Lojas ." +
                        "?x :Atividade ?Atividade.}"

        );

        QueryExecution queryExecution = QueryExecutionFactory.create(query,model);
        ResultSet resultSet  = queryExecution.execSelect();
        System.out.println("batatao");

        while (resultSet.hasNext()){
            QuerySolution querySolution = resultSet.next();
            System.out.println(querySolution);
            String name = querySolution.getLiteral("?Atividade").getString();
            //int idade = querySolution.getLiteral("idade").getInt();
           //Cliente cliente = new Cliente();
            //cliente.setNome(name);
            //cliente.setIdade(idade);
            System.out.println("batata");
            System.out.println(querySolution);
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
       // LinkedList<Loja.Produtos> listaProdutos = new LinkedList<>();
        //Loja primeira = new Loja();
        //Loja.Produtos A = new Loja.Produtos("a", 10);
        //listaProdutos.add(A);
    }
}
