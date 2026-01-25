<img alt="gruvbox-plain logo with cold color scheme" width="75" height="75" src="https://github.com/hermannm/gruvbox-plain/blob/assets/logos/gruvbox-plain-cold.png?raw=true" /><img alt="gruvbox-plain logo with warm color scheme" width="75" height="75" src="https://github.com/hermannm/gruvbox-plain/blob/assets/logos/gruvbox-plain-warm.png?raw=true" />

# gruvbox-plain

Color theme for IntelliJ (+ other JetBrains IDEs) and VSCode, based on
[`morhetz/gruvbox`](https://github.com/morhetz/gruvbox) but with a plainer color palette. Comes with
a cold and a warm variant.

- IntelliJ plugin: https://plugins.jetbrains.com/plugin/27768-gruvbox-plain
- VSCode extension: https://marketplace.visualstudio.com/items?itemName=hermannm.gruvbox-plain

**Contents**

- [Screenshots](#screenshots)
- [Color palette](#color-palette)
- [Installation](#installation)
  - [IntelliJ/JetBrains IDEs](#intellijjetbrains-ides)
  - [VSCode](#vscode)
- [Maintainer's guide](#maintainers-guide)
- [Credits](#credits)

## Screenshots

`gruvbox-plain-cold` in IntelliJ:

![Screenshot of gruvbox-plain-cold theme in IntelliJ](https://github.com/hermannm/gruvbox-plain/blob/assets/screenshots/gruvbox-plain-cold-intellij.png?raw=true)

`gruvbox-plain-warm` in VSCode:

![Screenshot of gruvbox-plain-warm theme in VSCode](https://github.com/hermannm/gruvbox-plain/blob/assets/screenshots/gruvbox-plain-warm-vscode.png?raw=true)

## Color palette

`gruvbox-plain` uses a limited subset of the gruvbox dark mode color palette. The table below shows
the general usage of the different colors.

|                                        Usage |                                        `gruvbox-plain-cold`                                        |                                        `gruvbox-plain-warm`                                        |
|---------------------------------------------:|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|
|            Variables, properties, plain text | `#ebdbb2`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/ebdbb2.png?raw=true) | `#ebdbb2`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/ebdbb2.png?raw=true) |
|                          Keywords, operators | `#d3869b`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/d3869b.png?raw=true) | `#fe8019`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/fe8019.png?raw=true) |
| Types, classes, namespaces, components, tags | `#83a598`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/83a598.png?raw=true) | `#fabd2f`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/fabd2f.png?raw=true) |
|                           Functions, methods | `#b8bb26`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/b8bb26.png?raw=true) | `#b8bb26`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/b8bb26.png?raw=true) |
|                   Values, language constants | `#8ec07c`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/8ec07c.png?raw=true) | `#8ec07c`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/8ec07c.png?raw=true) |
|                                  Punctuation | `#a89984`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/a89984.png?raw=true) | `#a89984`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/a89984.png?raw=true) |
|                      Comments, documentation | `#928374`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/928374.png?raw=true) | `#928374`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/928374.png?raw=true) |
|                             Background color | `#282828`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/282828.png?raw=true) | `#282828`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/282828.png?raw=true) |

For edge cases in languages where these may not apply, the color deemed most appropriate has been
chosen. This can always be overridden under `Preferences` -> `Editor` -> `Color Scheme` in
IntelliJ/JetBrains IDEs, or `editor.tokenColorCustomizations` in VSCode's `settings.json`.

## Installation

### IntelliJ/JetBrains IDEs

Click "Get" on the JetBrains Marketplace page:
https://plugins.jetbrains.com/plugin/27768-gruvbox-plain

Now `gruvbox-plain-cold` and `gruvbox-plain-warm` should be available under `Settings` ->
`Appearance and Behavior` -> `Appearance` -> `Theme`!

#### Manual installation

1. Clone the repo:
   ```
   git clone https://github.com/hermannm/gruvbox-plain.git
   ```
2. Navigate to the repo's `intellij` subfolder in your terminal
3. Build the plugin:
   ```
   ./gradlew buildPlugin
   ```
4. Open up `Settings` in your IDE
5. Go to the `Plugins` tab
6. Click the cogwheel in the top bar
7. Click `Install Plugin from Disk...`
8. Select the `.zip` file from `gruvbox-plain/intellij/build/distributions`

### VSCode

Click "Install" on the Visual Studio Marketplace page:
https://marketplace.visualstudio.com/items?itemName=hermannm.gruvbox-plain

Now `gruvbox-plain-cold` and `gruvbox-plain-warm` should be available under `Settings` ->
`Workbench: Color Theme`!

I recommend installing the
[Gruvbox Material Icons extension](https://marketplace.visualstudio.com/items?itemName=navernoedenis.gruvbox-material-icons)
as well, to complete the theme.

#### Manual installation

1. Install the VSCode extension manager:
   ```
   npm install -g @vscode/vsce
   ```
2. Clone the repo:
   ```
   git clone https://github.com/hermannm/gruvbox-plain.git
   ```
3. Navigate to the repo's `vscode` subfolder in your terminal
4. Package the extension:
   ```
   vsce package
   ```
5. Go to the `Extensions` tab in VSCode
6. Click `...` in the top right of the tab
7. Click `Install from VSIX...`, and select the `.vsix` file from `gruvbox-plain/vscode`

## Maintainer's guide

### Publishing a new release

- Bump `version` in `intellij/build.gradle.kts` and `vscode/package.json`
- Add an entry to `CHANGELOG.md` (with the current date)
    - Remember to update the link section, and bump the version for the `[Unreleased]` link
- Copy `CHANGELOG.md` to `vscode/CHANGELOG.md`
- Create commit and tag for the release (update `TAG` variable in below command):
  ```
  TAG=vX.Y.Z && git commit -m "Release ${TAG}" && git tag -a "${TAG}" -m "Release ${TAG}" && git log --oneline -2
  ```
- Publish JetBrains plugin:
  - Build the plugin:
    ```
    ./intellij/gradlew buildPlugin
    ```
  - Go to https://plugins.jetbrains.com/author/me, and log in with your JetBrains account
  - Click the plugin, and then "Upload update"
  - Select the newly built `.zip` file from `gruvbox-plain/intellij/build/distributions`
  - Confirm "Upload update"
- Publish VSCode extension:
  - Check that you have `vsce` installed:
    ```
    vsce --version
    ```
    - If you don't have it installed:
      ```
      npm install -g @vscode/vsce
      ```
    - If you do have it installed, update it:
      ```
      npm update -g @vscode/vsce
      ```
  - Login:
    ```
    vsce login
    ```
    - You may have to get a personal access token from https://dev.azure.com
      - Top right settings icon -> Personal Access Tokens
  - Publish:
    ```
    vsce publish
    ```
    - If you have issues, see the docs:
      https://code.visualstudio.com/api/working-with-extensions/publishing-extension
- Push the commit and tag:
  ```
  git push && git push --tags
  ```
    - Our release workflow will then create a GitHub release with the pushed tag's changelog entry

## Credits

- [`morhetz/gruvbox`](https://github.com/morhetz/gruvbox) for the original color scheme
    - _Copyright (c) 2017 Pavel Pertsev,
      [MIT/X11 license](https://github.com/morhetz/gruvbox#license)_
- [`jdinhify/vscode-theme-gruvbox`](https://github.com/jdinhify/vscode-theme-gruvbox) for the base
  VSCode UI theme
    - _Copyright (c) 2017 JD,
      [MIT license](https://github.com/jdinhify/vscode-theme-gruvbox/blob/main/LICENSE)_
- [`Vincent-P/gruvbox-intellij-theme`](https://github.com/Vincent-P/gruvbox-intellij-theme) for the
  base IntelliJ UI theme
    - _Copyright (c) 2019 Vincent Parizet,
      [MIT license](https://github.com/Vincent-P/gruvbox-intellij-theme/blob/master/LICENSE)_
