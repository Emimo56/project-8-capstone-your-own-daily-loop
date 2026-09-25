# Progress

## In progress

## Open / needs a human

- 2026-09-25 — `spring-boot-starter-web` and `spring-boot-starter-test`: Maven
  reports 3.5.5 -> 4.2.0-M2, but both are BOM-managed by
  `spring-boot-starter-parent` (no explicit version in pom.xml) and the
  target is a pre-release milestone. Not bumped per the audit rules
  (no BOM overrides, no pre-releases). Will become actionable once Spring
  Boot 4.x reaches a stable release.
- 2026-09-25 — `spring-boot-starter-parent` itself has a newer version
  available beyond 3.5.16: 4.2.0-M2. This is a major version bump and a
  pre-release milestone, so it was skipped. A human should evaluate the
  Spring Boot 4.x migration separately once it's out of milestone status.
- 2026-09-25 — `spring-boot-maven-plugin`: same situation as the two
  starters above (parent-managed, pre-release major target). Not bumped.

## Done

- 2026-09-25 — `spring-boot-starter-parent` 3.5.5 -> 3.5.16 (patch bump,
  reviewer PASS): https://github.com/Emimo56/project-8-capstone-your-own-daily-loop/pull/5

## Run log

- 2026-09-25 13:59 — checked 1, new PRs 1, new notes 3, skipped (already noted) 0