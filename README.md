# Java Sorting Algorithm Analyzer

[![Repo Size](https://img.shields.io/github/repo-size/drussell33/Java-Sorting-Algorithm-Analyzer)](https://github.com/drussell33/Java-Sorting-Algorithm-Analyzer)
[![Last Commit](https://img.shields.io/github/last-commit/drussell33/Java-Sorting-Algorithm-Analyzer)](https://github.com/drussell33/Java-Sorting-Algorithm-Analyzer/commits/main)
[![Top Language](https://img.shields.io/github/languages/top/drussell33/Java-Sorting-Algorithm-Analyzer)](https://github.com/drussell33/Java-Sorting-Algorithm-Analyzer)
[![Open Issues](https://img.shields.io/github/issues/drussell33/Java-Sorting-Algorithm-Analyzer)](https://github.com/drussell33/Java-Sorting-Algorithm-Analyzer/issues)

## Description

Java Sorting Algorithm Analyzer is a small Java project for benchmarking and classifying the behavior of several classic sorting algorithms using measured comparison counts. It includes implementations of insertion sort, selection sort, merge sort, and quicksort, then analyzes the observed results against candidate complexity classes to estimate the best Big-O fit.

## Key Features

- Implements four sorting algorithms behind a shared `ISort` interface:
  - Insertion sort
  - Selection sort
  - Merge sort
  - Quicksort
- Measures comparison counts returned directly from each sort implementation
- Generates multiple input distributions for analysis:
  - Sorted
  - Reverse-sorted
  - Random
- Benchmarks each algorithm across multiple array sizes
- Classifies measured growth against several complexity candidates:
  - `O(1)`
  - `O(log N)`
  - `O(N)`
  - `O(N log N)`
  - `O(N^2)`
  - `O(N^3)`
  - `O(2^N)`
- Produces ratio and error metrics through a dedicated `Analysis` result object
- Includes validation logic to confirm arrays are sorted correctly
- Includes a `TestDriver` with expected comparison counts and analyzer classification checks
- Provides reference algorithm snippets in the top-level `SortingAlgorithms/` directory

## Tech Stack

### Backend
- Java
- Package-based object-oriented design under `edu.wou.cs361.sorting`

### Frontend
- None
- Console-based execution and output

### Database
- None

### Tools / Services
- Plain Java source layout
- IntelliJ IDEA module file (`SortingAnalyzer.iml`)
- Git / GitHub

## Architecture Overview

The project is organized as a console-based Java application with no separate frontend or database layer. Sorting implementations conform to the `ISort` contract, which allows the benchmarking workflow to execute each algorithm uniformly and collect comparison-count metrics for the same generated datasets.

At the analysis layer, `Analyzer` implements `IAnalyzer` and compares measured counts against multiple candidate growth functions by normalizing the counts into ratios and computing average relative error. The selected result is returned as an `Analysis` object, which acts as a lightweight data container for ratios, error, and the inferred Big-O classification.

`SortAnalyzer` serves as the orchestration entry point for end-to-end benchmarking. It generates test datasets, runs each sorting algorithm, invokes the analyzer, prints results, and checks both sorted output and expected comparison totals. `TestDriver` provides a more explicit verification harness for regression-style validation of sort behavior and analyzer classification logic.

### Notable Design Elements
- Interface-based abstraction with `ISort` and `IAnalyzer`
- DTO-style result container with `Analysis`
- Separation of concerns between sorting, analysis, orchestration, and validation
- Deterministic random-data generation using a fixed seed

## Project Structure

```tree
Java-Sorting-Algorithm-Analyzer/
├── .idea/
├── SortingAlgorithms/
│   ├── InsertionSortStd.java
│   ├── MergeSortStd.java
│   ├── QuickSortStd.java
│   └── SelectionSortStd.java
├── src/
│   └── edu/
│       └── wou/
│           └── cs361/
│               └── sorting/
│                   ├── Analysis.java
│                   ├── Analyzer.java
│                   ├── IAnalyzer.java
│                   ├── ISort.java
│                   ├── InsertionSort.java
│                   ├── MergeSort.java
│                   ├── QuickSort.java
│                   ├── SelectionSort.java
│                   ├── SortAnalyzer.java
│                   └── TestDriver.java
├── .gitignore
├── README.md
└── SortingAnalyzer.iml
```

### Important Directories and Files

- `src/edu/wou/cs361/sorting/`  
  Main source package containing the sorting implementations, analyzer logic, benchmark runner, and test harness.

- `SortingAlgorithms/`  
  Reference or standard algorithm snippets kept separately from the package-based source tree.

- `SortAnalyzer.java`  
  Main benchmark runner that generates datasets, executes sorts, analyzes comparison counts, and prints results.

- `TestDriver.java`  
  Verification harness for checking expected comparison totals and validating inferred complexity classes.

- `Analyzer.java`  
  Complexity classifier that compares benchmark output against candidate asymptotic growth models.

## Getting Started

### Prerequisites

- JDK 10 or newer
  - The code uses local variable type inference (`var`), which requires Java 10+
- Git
- A terminal or IDE capable of compiling and running Java source files

### Installation

```bash
git clone https://github.com/drussell33/Java-Sorting-Algorithm-Analyzer.git
cd Java-Sorting-Algorithm-Analyzer
```

### Compile

```bash
javac -d out src/edu/wou/cs361/sorting/*.java
```

### Usage

Run the benchmark analyzer:

```bash
java -cp out edu.wou.cs361.sorting.SortAnalyzer
```

Run the validation test driver:

```bash
java -cp out edu.wou.cs361.sorting.TestDriver
```

### What the Program Does

- Builds datasets for sorted, reverse, and random input cases
- Executes each sort implementation over the configured sizes
- Records comparison counts
- Estimates the best matching complexity class from the measured data
- Prints benchmark and analysis information to the console

## Roadmap

- [x] Implement insertion sort
- [x] Implement selection sort
- [x] Implement merge sort
- [x] Implement quicksort
- [x] Add shared sort/analyzer interfaces
- [x] Add comparison-count benchmarking
- [x] Add complexity classification output
- [x] Add deterministic test data generation
- [x] Add validation for sorted output
- [x] Add regression-style comparison count checks
- [ ] Add a build tool configuration such as Maven or Gradle
- [ ] Add JUnit-based automated tests
- [ ] Add configurable benchmark sizes and data distributions
- [ ] Export benchmark results to CSV or JSON
- [ ] Add charts or visualizations for complexity trends
- [ ] Add additional sorting algorithms such as heap sort or shell sort
- [ ] Add command-line arguments for selecting algorithms and input modes

## Contributing

Contributions are welcome.

1. Fork the repository
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-change
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your change"
   ```
4. Push your branch:
   ```bash
   git push origin feature/your-change
   ```
5. Open a Pull Request

When contributing, keep changes focused, preserve the existing package structure, and update documentation or test coverage when applicable.

## Screenshots / Demo

_No screenshots or demo assets are currently included in the repository._

Suggested additions for a future update:
- Console output example from `SortAnalyzer`
- Test run example from `TestDriver`
- Visual chart comparing comparison growth across algorithms

## Contact

- GitHub: [drussell33](https://github.com/drussell33)
