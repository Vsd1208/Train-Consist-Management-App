public class UseCase15TrainConsistigant {

    // CUSTOM RUNTIME EXCEPTION
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety validation
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException(
                            "Unsafe cargo! Rectangular bogie cannot carry petroleum."
                    );
                }

                // If safe, assign cargo
                this.cargo = cargo;
                System.out.println("Cargo '" + cargo + "' assigned to " + shape + " bogie.");

            } catch (CargoSafetyException e) {
                // Handle unsafe assignment
                System.out.println("Error: " + e.getMessage());

            } finally {
                // Always executes (logging/cleanup)
                System.out.println("Cargo assignment attempt completed.\n");
            }
        }
    }

    public static void main(String[] args) {

        // Create bogies
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        // Safe assignment
        bogie1.assignCargo("Coal");

        // Unsafe assignment (will trigger exception)
        bogie1.assignCargo("Petroleum");

        // Safe assignment
        bogie2.assignCargo("Petroleum");
    }
}