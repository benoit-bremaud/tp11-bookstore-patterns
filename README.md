# TP11 - Bookstore Patterns (Java)

Java practical work implementing multiple design patterns in a single bookstore domain.

## Implemented patterns

- Repository (`LivreRepository`, `LivreRepositoryImpl`)
- Lazy Loading (`Commande` book loading by ids)
- Strategy (`FraisPortColissimoStrategy`, `FraisPortMondialRelayStrategy`)
- State (`CommandeNouvelle`, `CommandeEnCours`, `CommandeExpediee`)
- Adapter (`EmailNotificationAdapter`)

## Project structure

- `src/tp11/` domain entities and main runner
- `src/tp11/dto/` transfer objects
- `src/tp11/repository/` repository abstraction and in-memory implementation
- `src/tp11/strategy/` shipping cost strategies
- `src/tp11/state/` order state transitions
- `src/tp11/adapter/` notification adapter + external email service simulation

## Run

```bash
javac $(find src -name "*.java")
java -cp src tp11.Main
```

## Git workflow

Conventional Commits and branch naming aligned with Angular-style conventions are documented in `WORKFLOW.md`.
