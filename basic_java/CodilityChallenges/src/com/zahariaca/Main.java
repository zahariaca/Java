package com.zahariaca;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private ShipPart[][] playGround;

    public static void main(String[] args) {
        Main main = new Main();

        main.solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");

        System.out.println("\n=========================================\n");

        System.out.println("Application result: " + main.solution(12, "1A 2A,12A 12A", "12A"));
    }

    public String solution(int N, String S, String T) {
        if (N > 26) {
            throw new UnsupportedOperationException(String.format("Application does not support map sizes larger than 26. N=%s", N));
        }
        playGround = new ShipPart[N][N];

        List<Ship> ships = createShips(S);

        populatePlayGround(playGround, ships);

        addHitsToModel(playGround, T);

        System.out.println(Arrays.deepToString(playGround).replace("],", "]\n"));

        long numberOfShipsDestroyed = ships.stream().filter(Ship::isDestroyed).count();
        long numberOfShipsHit = ships.stream().filter(Ship::isPartiallyDestroyed).count();

        String result = String.format("%s,%s", numberOfShipsDestroyed, numberOfShipsHit);

        return result;
    }

    private List<Ship> createShips(String S) {
        String[] corners = S.split(",");
        String[] topLeft = corners[0].split(" ");
        String[] bottomRight = corners[1].split(" ");

        String leftCoordinateOne = topLeft[0];
        String leftCoordinateTwo = topLeft[1];
        String rightCoordinateOne = bottomRight[0];
        String rightCoordinateTwo = bottomRight[1];


        List<Coordinate> leftCoordinates = parseCoordinatesFromInputString(leftCoordinateOne, leftCoordinateTwo);
        List<Coordinate> rightCoordinates = parseCoordinatesFromInputString(rightCoordinateOne, rightCoordinateTwo);

        Ship leftShip = new Ship(instantiateShipPartsWithCoordinates(leftCoordinates));
        Ship rightShip = new Ship(instantiateShipPartsWithCoordinates(rightCoordinates));

        List<Ship> ships = new ArrayList<>();
        ships.add(leftShip);
        ships.add(rightShip);
        return ships;
    }


    private List<Coordinate> parseCoordinatesFromInputString(String coordinateOne, String coordinateTwo) {
        List<Coordinate> coordinatesList = new ArrayList<>();

        Coordinate top = getCoordinateFromString(coordinateOne);
        Coordinate bottom = getCoordinateFromString(coordinateTwo);

        coordinatesList.add(top);
        coordinatesList.add(bottom);

        coordinatesList.addAll(getAdjacentCoordinates(top, bottom));

        return coordinatesList.stream().distinct().collect(Collectors.toList());
    }

    private Coordinate getCoordinateFromString(String coordinate) {
        Matcher digitMatcher = Pattern.compile("\\d+").matcher(coordinate);
        Matcher wordMatcher = Pattern.compile("\\D").matcher(coordinate);

        //TODO: should check for matches or throw exception. omitted for simplicity
        if (digitMatcher.find() && wordMatcher.find() && wordMatcher.group().length() == 1) {

            int row = Integer.parseInt(digitMatcher.group());
            int col = wordMatcher.group().charAt(0) - 64;

            return new Coordinate(row, col);
        } else {
            throw new RuntimeException("Input is incorrect");
        }
    }

    private List<Coordinate> getAdjacentCoordinates(Coordinate top, Coordinate bottom) {
        //TODO: fix duplicate code
        List<Coordinate> coordinatesList = new ArrayList<>();
        int topRow = top.getRow();
        int bottomRow = bottom.getRow();
        int topColumn = top.getColumn();
        int bottomColumn = bottom.getColumn();

        if (topRow - bottomRow < 0) {
            // bottom row is larger numerically than top row
            while (topRow - bottomRow != 0) {
                topRow += 1;
                coordinatesList.add(new Coordinate(topRow, topColumn));
            }
        } else {
            // top row is larger numerically than bottom row
            while (topRow - bottomRow != 0) {
                topRow -= 1;
                coordinatesList.add(new Coordinate(topRow, topColumn));
            }
        }

        topRow = top.getRow();
        bottomRow = bottom.getRow();
        topColumn = top.getColumn();
        bottomColumn = bottom.getColumn();

        if (topColumn - bottomColumn < 0) {
            while (topColumn - bottomColumn != 0) {
                topColumn += 1;
                coordinatesList.add(new Coordinate(topRow, topColumn));
            }
        } else {
            while (topColumn - bottomColumn != 0) {
                topColumn -= 1;
                coordinatesList.add(new Coordinate(topRow, topColumn));
            }
        }

        return coordinatesList;
    }

    private  List<ShipPart> instantiateShipPartsWithCoordinates(List<Coordinate> coordinates) {
        List<ShipPart> shipParts = new ArrayList<>();

        coordinates.forEach(coordinate -> shipParts.add(new ShipPart(coordinate, false)));

        return shipParts;
    }

    private void populatePlayGround(ShipPart[][] playGround, List<Ship> ships) {
        ships.stream()
                .map(ship -> ship.getParts())
                .flatMap(Collection::stream)
                .forEach(shipPart -> playGround[shipPart.getCoordinate().getRow() - 1][shipPart.getCoordinate().getColumn() - 1] = shipPart);
    }

    private void addHitsToModel(ShipPart[][] playGround, String T) {
        String[] hits = T.split(" ");
        Stream.of(hits).forEach(hit -> {
            Coordinate coordinate = getCoordinateFromString(hit);
            ShipPart possibleShipPart = playGround[coordinate.getRow()-1][coordinate.getColumn()-1];
            if (possibleShipPart != null) {
                possibleShipPart.hitShip();
            }
        });
    }

    class Coordinate {
        int column;
        int row;

        Coordinate(int row, int column) {
            this.column = column;
            this.row = row;
        }

        int getColumn() {
            return column;
        }

        int getRow() {
            return row;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return column == that.column &&
                    row == that.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(column, row);
        }
    }

    class ShipPart {
        Coordinate coordinate;
        boolean isHit;

        ShipPart(Coordinate coordinate, boolean isHit) {
            this.coordinate = coordinate;
            this.isHit = isHit;
        }

        void hitShip() {
            isHit = true;
        }

        Coordinate getCoordinate() {
            return coordinate;
        }

        boolean isHit() {
            return isHit;
        }

        @Override
        public String toString() {
            return "ShipPart{" +
                    "coordinate=" + coordinate +
                    ", isHit=" + isHit +
                    '}';
        }
    }

    class Ship {
        List<ShipPart> parts;

        Ship(List<ShipPart> parts) {
            this.parts = parts;
        }

        List<ShipPart> getParts() {
            return parts;
        }

        boolean isDestroyed() {
            return parts.stream().allMatch(ShipPart::isHit);
        }

        boolean isHit() {
            return parts.stream().anyMatch(ShipPart::isHit);
        }

        boolean isPartiallyDestroyed() {
            return !isDestroyed() && isHit();
        }

        @Override
        public String toString() {
            return "Ship{" +
                    "parts=" + parts +
                    '}';
        }
    }
}
