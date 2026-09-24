# Verification
1. Run `mvn test`.
2. Start with `mvn spring-boot:run`.
3. GET `/rewards`.
4. GET `/rewards/C001` and verify Alice: Jan 115, Feb 250, Mar 150, total 515.
5. GET `/transactions?customerId=C001&startMonth=2026-01&endMonth=2026-02`.
6. Try different beginning/ending months; endpoints treat both months as inclusive.
7. GET `/transactions?startMonth=2026-01&endMonth=2026-03` for all customers.
