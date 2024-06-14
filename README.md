# Intergalactic Trade Application

## Overview

This application assists in buying and selling common metals and dirt across the galaxy by converting numbers and units following conventions similar to Roman numerals.

## Program Flow

1. User provides the file path to the `MerchantGuideController`.
2. `MerchantGuideController` calls `TradeService.calculateTrade(path)`.
3. `TradeService` uses `FileReader` to read the file and get a list of strings.
4. Parser classes (`InterGalacticValueParser` and `MetallicCreditParser`) parse these strings to extract intergalactic values and metal values.
5. `QuerySolverService` processes queries from the list of strings, classifies them, and solves them.
6. The answers are printed on the screen.

## Assumptions

- Data in the file is considered the source of truth.
- It will answer only those queries which are present in the file.

## Extension (Future Preparedness)

- The user can also provide a single query if they want to perform an operation that is not part of the queries in the file.

## Class Diagram

### Controller

#### MerchantGuideController

- **State:**
    - `private TradeService tradeService`
- **Behaviour:**
    - `public Response calculateTrade(String filePath)`

### Service

#### TradeService

- **State:**
    - `private InterGalacticUnitRepository interGalacticUnitRepository`
    - `private MetallicUnitRepository metallicUnitRepository`
- **Behaviour:**
    - `boolean calculateTrade(String path)`
    - `public List<String> FileReader.readFile(String path)`
    - `public void Parser.parse(List<String> lines)`
    - `public List<String> QuerySolver.solve(Query query)`

### I/O Package

#### FileReader

- **State:**
    - `private List<String> fileData`
- **Behaviours:**
    - `public List<String> readFile(String path)`

### Parser Package

#### InterGalacticValueParser

- **State:**
    - `private FileReader fileReader`
    - `private InterGalacticUnitRepository interGalacticUnitRepository`
- **Behaviours:**
    - `public void parse(List<String> lines)`

#### MetallicCreditParser

- **State:**
    - `private FileReader fileReader`
    - `private InterGalacticUnitRepository interGalacticUnitRepository`
- **Behaviours:**
    - `public void parse(List<String> lines)`
        - Inner method: `MetalCreditCalculator.calculateCredit(String line)`

### Util Package

#### MetalCreditCalculator

- **Behaviours:**
    - `public Map<String, Double> calculateCredit(String lines)`

### Query Solver Service

#### QuerySolverService

- **State:**
    - `private List<String> queryAnswers`
    - `private InterGalacticUnitRepository interGalacticUnitRepository`
    - `private MetallicUnitRepository metallicUnitRepository`
- **Behaviours:**
    - `public List<String> solve(List<Query> queries)`
        - For each line in queries:
            - Use design pattern:
                - If String contains the metal:
                    - `answer.add(GetMetalTrade.getTradeForMetal(interGalacticUnitRepository.getUnits(), metallicUnitRepository.getCredits(), String query))`
                - Else if String contains the InterGalactics (glob...):
                    - `answer.add(GetInterGalacticTrade.getTradeForGalactics(interGalacticUnitRepository.getUnits(), String query))`
                - Else:
                    - `answer.add("I have no idea what you are talking about")`

### Domain Package

#### Model

##### Entity

###### InterGalacticUnit

- **State:**
    - `private String unitValue`
    - `private String romanValue`

###### MetallicUnit

- **State:**
    - `private String metal`
    - `private long credit`

##### ValueObject

###### RomanNumeral

- Enum

##### Service

- Strategy Design Pattern can be used:

    - **Interface: TradeEvaluator**
        - `String executeQuery()`

    - **MetalTradeEvaluator**
        - `String executeQuery(interGalacticUnitRepository.getUnits(), metallicUnitRepository.getCredits(), String query)`

    - **InterGalacticTradeEvaluator**
        - `String executeQuery(interGalacticUnitRepository.getUnits(), String query)`

### Repository Package

#### DTO

##### Query

- Interface:
    - `metalQueries`
    - `interGalacticQueries`

#### InterGalacticUnitRepository

- **Behaviours:**
    - `void addInterGalacticUnit(List<InterGalacticUnit> units)`
    - `List<InterGalacticUnit> getUnits()`

#### MetallicUnitRepository

- **Behaviours:**
    - `void addMetallicUnit(List<MetallicUnit> units)`
    - `List<MetallicUnit> getCredits()`

### Database Package

