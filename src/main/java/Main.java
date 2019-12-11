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
        model.read("E:\\Downloads\\centro_comercial\\CentroCormercial.ttl");

        Query query = QueryFactory.create(
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX : <http://www.semanticweb.org/mikae/ontologies/2019/9/centro_comercial#>\n" +
                        "SELECT "
        );

        QueryExecution queryExecution = QueryExecutionFactory.create(query,model);
        ResultSet resultSet  = queryExecution.execSelect();

        while (resultSet.hasNext()){
            QuerySolution querySolution = resultSet.next();
            String name = querySolution.getLiteral("name").getString();
            int idade = querySolution.getLiteral("idade").getInt();
            Cliente cliente = new Cliente();
            cliente.setNome(name);
            cliente.setIdade(idade);
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
