package com.tangbaobao.graphqlcurd.graphql.schema;

import com.tangbaobao.graphqlcurd.graphql.fetchers.AuthorFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author tangxuejun
 * @version 2020/4/4 9:46 下午
 */
@Component
public class AuthorSchema {
    private final AuthorFetcher authorFetcher;
    private GraphQL graphQL;

    public AuthorSchema(AuthorFetcher authorFetcher) {
        this.authorFetcher = authorFetcher;
    }

    @Bean
    public GraphQL genGraphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws FileNotFoundException {
        GraphQLSchema graphQLSchema = this.graphQLSchema(ResourceUtils.getFile("classpath:graphql/author.graphqls"));
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema graphQLSchema(File sdl) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = this.buildRunTimeWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private RuntimeWiring buildRunTimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query",
                        builder -> builder.dataFetcher("allAuthor", authorFetcher.getAllAuthor())
                                .dataFetcher("authorById", authorFetcher.authorById()))
                .type("Mutation",
                        builder -> builder.dataFetcher("saveAuthor", authorFetcher.saveAuthor())
                                .dataFetcher("deleteAuthorById", authorFetcher.deleteAuthor())
                )
                .build();
    }

}
