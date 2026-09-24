# Retailer Rewards Program

Simple Spring Boot/Maven REST API for a retailer rewards program.

## Rules
- Below $50: 0 points
- $50-$100: 1 point per dollar above $50
- Above $100: 50 points for the $50-$100 band + 2 points per dollar above $100
- Fractional points are rounded down.

## Run
Windows: `mvnw.cmd spring-boot:run` (or `mvn spring-boot:run`)

Tests: `mvnw.cmd test` (or `mvn test`)

Java 17, Spring Boot 3.5.5.

## Endpoints

### Reward points per customer per month
`GET /rewards`

Returns every customer's monthly reward points and total.

`GET /rewards/{customerId}`

Example: `GET /rewards/C001`

### Transactions by customer and selected month range
`GET /transactions?customerId=C001&startMonth=2026-01&endMonth=2026-03`

`startMonth` and `endMonth` use `YYYY-MM` and are inclusive. `customerId` is optional, so this also works for all customers:

`GET /transactions?startMonth=2026-01&endMonth=2026-03`

All filters are optional, so `/transactions` returns all transactions.

If `startMonth` is after `endMonth`, or a month is not `YYYY-MM`, the API returns HTTP 400.

## Sample data
22 transactions are created in memory for 5 customers: Alice, Bob, Carol, David and Eva. Expected monthly totals are documented in `transactions.xlsx`.

## Design
`Controller -> Service -> Repository`. Reward calculation is isolated in `RewardPointsCalculator` for easy testing and maintenance.

## Tests
Unit tests cover reward-rule boundaries and examples. Service tests cover monthly aggregation and inclusive month filtering. UAT-style MockMvc tests cover the REST endpoints and bad input.
