package com.techoral.java.legacy.context;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates modern thread context management using structured concurrency.
 * This class shows how to manage request context in a thread-safe manner,
 * particularly useful in web applications and microservices.
 */
public class ModernRequestContext {
    
    // Define thread-local values for request context
    private static final ThreadLocal<String> REQUEST_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();
    private static final ThreadLocal<Long> TIMESTAMP = new ThreadLocal<>();
    
    /**
     * Simulates processing a request with context information.
     * @param userId The ID of the user making the request
     */
    public static void processRequest(String userId) {
        String requestId = UUID.randomUUID().toString();
        long timestamp = System.currentTimeMillis();
        
        try {
            // Set the context values for this request
            REQUEST_ID.set(requestId);
            USER_ID.set(userId);
            TIMESTAMP.set(timestamp);
            
            // Log the start of request processing
            logRequestStart();
            
            // Simulate some async processing
            processRequestAsync();
            
            // Log the end of request processing
            logRequestEnd();
        } finally {
            // Clean up thread locals
            REQUEST_ID.remove();
            USER_ID.remove();
            TIMESTAMP.remove();
        }
    }
    
    /**
     * Simulates asynchronous processing of the request.
     * The context values are propagated to async tasks using thread locals.
     */
    private static void processRequestAsync() {
        // Capture context values
        String requestId = REQUEST_ID.get();
        String userId = USER_ID.get();
        Long timestamp = TIMESTAMP.get();
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            // Submit multiple tasks that use the request context
            executor.submit(() -> runWithContext(requestId, userId, timestamp, ModernRequestContext::performDatabaseOperation));
            executor.submit(() -> runWithContext(requestId, userId, timestamp, ModernRequestContext::callExternalService));
            executor.submit(() -> runWithContext(requestId, userId, timestamp, ModernRequestContext::updateCache));
            
            // Ensure all tasks complete
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Async processing interrupted: " + e.getMessage());
        } finally {
            executor.shutdownNow();
        }
    }
    
    /**
     * Helper method to run a task with the captured context.
     */
    private static void runWithContext(String requestId, String userId, Long timestamp, Runnable task) {
        try {
            REQUEST_ID.set(requestId);
            USER_ID.set(userId);
            TIMESTAMP.set(timestamp);
            task.run();
        } finally {
            REQUEST_ID.remove();
            USER_ID.remove();
            TIMESTAMP.remove();
        }
    }
    
    private static void performDatabaseOperation() {
        logOperation("Performing database operation");
        simulateWork(1000);
    }
    
    private static void callExternalService() {
        logOperation("Calling external service");
        simulateWork(1500);
    }
    
    private static void updateCache() {
        logOperation("Updating cache");
        simulateWork(500);
    }
    
    private static void logRequestStart() {
        System.out.printf("Request started - ID: %s, User: %s, Time: %d%n",
            REQUEST_ID.get(), USER_ID.get(), TIMESTAMP.get());
    }
    
    private static void logRequestEnd() {
        long duration = System.currentTimeMillis() - TIMESTAMP.get();
        System.out.printf("Request completed - ID: %s, Duration: %d ms%n",
            REQUEST_ID.get(), duration);
    }
    
    private static void logOperation(String operation) {
        System.out.printf("[%s] %s for user %s%n",
            REQUEST_ID.get(), operation, USER_ID.get());
    }
    
    private static void simulateWork(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void main(String[] args) {
        // Simulate processing multiple requests
        processRequest("user123");
        processRequest("user456");
        processRequest("user789");
    }
} 