# gruvbox-plain

Theme based on [morhetz/gruvbox](https://github.com/morhetz/gruvbox), but with a plainer color palette for syntax highlighting.

## Syntax Colors

gruvbox-plain uses a limited subset of the gruvbox dark mode color palette for syntax highlighting. The below table shows the general usage of the different colors.

| Hex       |                          Color                           | Usage                             |
| --------- | :------------------------------------------------------: | --------------------------------- |
| `#ebdbb2` | ![](https://via.placeholder.com/15/ebdbb2/000000?text=+) | Variables, properties, plain text |
| `#fe8019` | ![](https://via.placeholder.com/15/fe8019/000000?text=+) | Keywords, operators               |
| `#fabd2f` | ![](https://via.placeholder.com/15/fabd2f/000000?text=+) | Types, classes, components, tags  |
| `#b8bb26` | ![](https://via.placeholder.com/15/b8bb26/000000?text=+) | Functions, methods                |
| `#8ec07c` | ![](https://via.placeholder.com/15/8ec07c/000000?text=+) | Values, language constants        |
| `#a89984` | ![](https://via.placeholder.com/15/a89984/000000?text=+) | Punctuation                       |
| `#928374` | ![](https://via.placeholder.com/15/928374/000000?text=+) | Comments, documentation           |

For edge cases in languages where these may not apply, the color deemed most appropriate has been chosen. This can always be overridden under `editor.tokenColorCustomizations` in your `settings.json`.

## Credits

- [morhetz/gruvbox](https://github.com/morhetz/gruvbox) for the original color scheme<br>
  _Copyright (c) 2017 Pavel Pertsev, [MIT/X11 license](https://github.com/morhetz/gruvbox#license)_
- [jdinhify/vscode-theme-gruvbox](https://github.com/jdinhify/vscode-theme-gruvbox) for the base VSCode UI theme<br>
  _Copyright (c) 2017 JD, [MIT license](https://github.com/jdinhify/vscode-theme-gruvbox/blob/main/LICENSE)_
