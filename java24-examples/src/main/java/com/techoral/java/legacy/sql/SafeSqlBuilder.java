package com.techoral.java.legacy.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates safe SQL query building using Java 24's String Templates feature.
 * This class shows how to prevent SQL injection while building dynamic queries.
 */
public class SafeSqlBuilder {
    
    /**
     * Custom String Template Processor for SQL queries.
     * Handles proper escaping and parameter binding.
     */
    private static final class SqlProcessor {
        private final List<Object> parameters = new ArrayList<>();
        
        public String process(String[] fragments, Object[] values) {
            StringBuilder sql = new StringBuilder();
            int paramIndex = 0;
            
            for (int i = 0; i < fragments.length; i++) {
                sql.append(fragments[i]);
                if (i < values.length) {
                    sql.append("?");
                    parameters.add(values[i]);
                }
            }
            
            return sql.toString();
        }
        
        public List<Object> getParameters() {
            return parameters;
        }
    }
    
    /**
     * Builds a safe SQL query with parameters.
     * @param fragments The SQL query fragments
     * @param values The parameter values
     * @return A QueryBuilder instance containing the processed query and parameters
     */
    public static QueryBuilder buildQuery(String[] fragments, Object... values) {
        var processor = new SqlProcessor();
        String sql = processor.process(fragments, values);
        return new QueryBuilder(sql, processor.getParameters());
    }
    
    /**
     * Helper class to manage the built query and its parameters.
     */
    public static class QueryBuilder {
        private final String sql;
        private final List<Object> parameters;
        
        private QueryBuilder(String sql, List<Object> parameters) {
            this.sql = sql;
            this.parameters = parameters;
        }
        
        /**
         * Creates a PreparedStatement with the parameters bound.
         * @param connection The database connection
         * @return A PreparedStatement ready to be executed
         * @throws SQLException if there's an error preparing the statement
         */
        public PreparedStatement prepare(Connection connection) throws SQLException {
            PreparedStatement stmt = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }
            return stmt;
        }
        
        public String getSql() {
            return sql;
        }
        
        public List<Object> getParameters() {
            return parameters;
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        String tableName = "users";
        String name = "John";
        int age = 30;
        
        // Safe query building with String Templates
        var query = buildQuery(
            new String[]{"SELECT * FROM ", " WHERE name = ", " AND age > ", ""},
            tableName, name, age
        );
        
        System.out.println("Generated SQL: " + query.getSql());
        System.out.println("Parameters: " + query.getParameters());
        
        // Example with potential SQL injection attempt
        String maliciousInput = "' OR '1'='1";
        var safeQuery = buildQuery(
            new String[]{"SELECT * FROM users WHERE name = ", ""},
            maliciousInput
        );
        
        System.out.println("\nSQL Injection attempt handled safely:");
        System.out.println("Generated SQL: " + safeQuery.getSql());
        System.out.println("Parameters: " + safeQuery.getParameters());
    }
} 