package util;

public class CommandLineParser {
  public static CommandLineOptions parse(String[] args) {
    String inputFile = null;
    String outputFile = null;
    String viewType = null;
    int width = -1;
    int height = -1;

    int i = 0;
    while (i < args.length) {
      switch (args[i++]) {
        case "-in", "-i" -> inputFile = args[i++];
        case "-out", "-o" -> outputFile = args[i++];
        case "-view", "-v" -> {
          viewType = args[i++];
          if (viewType.equals("graphical")) {
            if (i >= args.length) {
              width = 1000;
              height = 1000;
            } else {
              width = Integer.parseInt(args[i++]);
              if (i < args.length) {
                height = Integer.parseInt(args[i++]);
              } else {
                height = 1000;
              }
            }
          }
        }
        default -> {
          System.out.println("Invalid command-line argument: " + args[i - 1]);
          System.exit(1);
        }
      }
    }

    // check the validity of the arguments
    if (inputFile == null) {
      System.out.println("Input file is required");
      System.exit(1);
    }
    if (viewType == null) {
      System.out.println("View type is required");
      System.exit(1);
    }
    if (!viewType.equals("web") && !viewType.equals("graphical")) {
      System.out.println("Invalid view type: " + viewType);
      System.exit(1);
    }
    if (viewType.equals("web") && outputFile == null) {
      System.out.println("Output file is required for web view");
      System.exit(1);
    }
    if(viewType.equals("graphical") && (width == -1 || height == -1)) {
      System.out.println("Width and height are required for graphical view");
      System.exit(1);
    }
    if(viewType.equals("graphical") && (width < 0 || height < 0)) {
      System.out.println("Width and height must be positive integers");
      System.exit(1);
    }

    return new CommandLineOptions(inputFile, outputFile, viewType, width, height);
  }
}
