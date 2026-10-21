# GitConflictDemo-Baoding

A minimal two-button Android application built for the **"Collaborating with GitLab and Resolving Merge Conflicts"** practical (Mobile Computing & Network Architecture).

## What this app does

- Shows two buttons (`Button One`, `Button Two`) on a single screen.
- Each button shows a short Toast message when tapped.
- Both buttons start with the same **blue-grey** colour (`#546E7A`) and 12dp rounded corners.

## How this repository is organised for the exercise

The exercise simulates two developers working on the same codebase:

| Branch | Change |
|---|---|
| `main` | Initial application, both buttons blue-grey |
| `feature-red-button` | Both buttons recoloured red (`#E53935`) |
| `feature-green-button` | Both buttons recoloured green (`#43A047`) |

Both feature branches modify the **same `app:backgroundTint` lines** in `app/src/main/res/layout/activity_main.xml`, so merging the second branch into `main` produces an intentional merge conflict. The conflict is then resolved by the group and the resolved design is merged into `main`.

## How to build and run

1. Open this folder in Android Studio.
2. Let Gradle sync complete.
3. Run the `app` configuration on an Android emulator (or a physical device).

## Group

- Group name: **Baoding**
