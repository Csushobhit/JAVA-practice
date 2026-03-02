import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartMonitorSystem {

    static class ResourceOverloadException extends Exception {
        public ResourceOverloadException(String message) {
            super(message);
        }
    }

    static class CriticalFailureException extends RuntimeException {
        public CriticalFailureException(String message) {
            super(message);
        }
    }

    static abstract class Resource {

        private double usage;

        public double getUsage() {
            return usage;
        }

        public void setUsage(double usage) {
            if (usage < 0 || usage > 100) {
                throw new IllegalArgumentException("Usage must be between 0 and 100");
            }
            this.usage = usage;
        }

        public void displayUsage() {
            System.out.println(getClass().getSimpleName() + " Usage: " + usage + "%");
        }

        public abstract void checkHealth() throws ResourceOverloadException;
    }

    static class CPUResource extends Resource {

        public void checkHealth() throws ResourceOverloadException {
            if (getUsage() > 90) {
                throw new CriticalFailureException("CPU critical failure");
            } else if (getUsage() > 75) {
                throw new ResourceOverloadException("CPU overload detected");
            } else {
                System.out.println("CPU functioning normally");
            }
        }
    }

    static class MemoryResource extends Resource {

        public void checkHealth() throws ResourceOverloadException {
            if (getUsage() > 85) {
                throw new CriticalFailureException("Memory critical failure");
            } else if (getUsage() > 70) {
                throw new ResourceOverloadException("Memory overload detected");
            } else {
                System.out.println("Memory functioning normally");
            }
        }
    }

    static class DiskResource extends Resource {

        public void checkHealth() throws ResourceOverloadException {
            if (getUsage() > 95) {
                throw new CriticalFailureException("Disk critical failure");
            } else if (getUsage() > 80) {
                throw new ResourceOverloadException("Disk overload detected");
            } else {
                System.out.println("Disk functioning normally");
            }
        }
    }

    static class Monitor {

        public static void monitor(Resource resource) throws ResourceOverloadException {
            resource.displayUsage();
            resource.checkHealth();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("1. Monitor CPU");
            System.out.println("2. Monitor Memory");
            System.out.println("3. Monitor Disk");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;

            try {

                choice = sc.nextInt();

                if (choice == 4) {
                    System.out.println("Exiting system");
                    break;
                }

                Resource resource;

                if (choice == 1) {
                    resource = new CPUResource();
                } else if (choice == 2) {
                    resource = new MemoryResource();
                } else if (choice == 3) {
                    resource = new DiskResource();
                } else {
                    System.out.println("Invalid choice");
                    continue;
                }

                System.out.print("Enter usage percentage: ");

                double usage = sc.nextDouble();

                resource.setUsage(usage);

                try {

                    Monitor.monitor(resource);

                } catch (ResourceOverloadException e) {

                    System.out.println("Warning: " + e.getMessage());

                } catch (CriticalFailureException e) {

                    System.out.println("Critical: " + e.getMessage());

                } finally {

                    System.out.println("Recovery actions completed");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input type");
                sc.nextLine();

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());

            } catch (Exception e) {

                System.out.println("Unexpected error: " + e.getMessage());

            } finally {

                System.out.println("System stable");

            }
        }

        sc.close();
    }
}