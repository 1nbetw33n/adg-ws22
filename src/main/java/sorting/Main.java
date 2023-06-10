package sorting;

/*
 * Created by 0x1nbetw33n on 04. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */


import java.util.List;
import java.util.Objects;
import java.util.Scanner;

final class Main {

        private final List<String> sorting_algos;
        private Object[] data;
        private String algo;
        private final Scanner sc;

        /**
         * Private constructor to prevent outside use.
         */
        private Main(){
                sc = new Scanner(System.in);
                sorting_algos = List.of("selection", "insertion", "bubble", "merge", "quick", "heap");
        }

        /**
         * Prompts the user to choose whether they want to generate random data or enter their own data.<br>
         * Depending on the answer, the data will be generated or the user will be prompted to enter the data.<br>
         * The data will then be sorted using the chosen algorithm.
         * @param main instance of the main class
         */
        private void select(final Main main) {
                System.out.println("Do you want to generate random data? [Y/n] ::");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                        generate_random_data();
                } else if (answer.equalsIgnoreCase("n")) {
                        use_custom_data();
                } else {
                        throw new IllegalArgumentException("Invalid answer :: " + "'" + answer + "'");
                }
                select_algo(main);
                Objects.requireNonNull(main.get_algo(algo))
                        .sort((Integer[]) data);
        }

        /**
         * Generates a random array of integers that will be sorted.
         */
        private void generate_random_data() {
                System.out.println("Enter the size of the data ::");
                int size = sc.nextInt();
                System.out.println("Enter the range of the data ::");
                int range = sc.nextInt();
                data = Util.generate_random_data(Integer.class, size, range);
                Util.print_array(data);
                //for some reason the scanner does not work for generating data - so I had to assign it twice to make it work
                algo = sc.nextLine();
        }

        /**
         * Prompts the user to enter the data they want to sort.
         */
        private void use_custom_data() {
                System.out.println(System.lineSeparator() + "Enter the data you want to sort in the following format ::"
                        + System.lineSeparator() + "{1,2,3} or {1, 2, 3}" + System.lineSeparator());
                String data_str = sc.nextLine();
                Util.is_valid_sorting_input(data_str); //TODO: allow everything that has a natural order (Strings, chars, numbers, etc.)
                data = util.StringParser.to_intArray(data_str);
        }

        /**
         * Displays all available sorting algorithms and prompts the user to choose one.
         * @param main instance of the main class
         */
        @SuppressWarnings("DuplicatedCode")
        private void select_algo(final Main main){
                System.out.println(System.lineSeparator() + "Which sorting algorithm do you want to use?");
                System.out.println("Available algorithms ::" + System.lineSeparator());
                sorting_algos.stream()
                        .map(algo -> {
                                int i = sorting_algos.indexOf(algo);
                                return algo + " -> " + (i + 1);
                        }).forEach(System.out::println);
                System.out.println("exit -> 0");
                System.out.println();
                System.out.println("Enter number ::" + System.lineSeparator());
                algo = sc.next();
                System.out.println();
                if (algo.equals("0")) {
                        System.out.println("Exiting now...");
                        System.exit(0);
                }
                System.out.println("-> " + main.get_algo(algo).getClass().getSimpleName() + " Sort <-" + System.lineSeparator());
        }

        /**
         * Gets the instance of the sorting algorithm based on the entered number.
         * @param number the name of the sorting algorithm
         * @return the instance of the sorting algorithm
         */
        private Sort get_algo(final String number) {
                return switch (number) {
                        case "1" -> new Selection();
                        case "2" -> new Insertion();
                        case "3" -> new Bubble();
                        case "4" -> new Merge();
                        case "5" -> new Quick();
                        //case "6": -> new Heap(); //TODO: implement heap sort
                        default -> null;
                };
        }



        /**
         * Runs the program.
         */
        private void run() {
                final Main main = new Main();
                main.select(main);
        }

        public static void main(String[] args) {
                new Main().run();
        }

}
