# Fashion Intelligence

Portfolio site for Natalie Rodríguez - Fashion Stylist & Retail Curation Expert.

## Structure

This is a ClojureScript application using Shadow-CLJS and Reagent (React wrapper).

### Directory Layout

```
fashion_intelligence/
├── public/
│   ├── index.html          # Minimal HTML entry point
│   └── images/             # Static images
│       └── Base Domenica.jpg
├── src/
│   └── fashion_intelligence/
│       ├── core.cljs       # Application initialization
│       ├── app.cljs        # Main app component
│       └── components/     # Individual page sections
│           ├── hero.cljs
│           ├── problem.cljs
│           ├── solution.cljs
│           ├── services.cljs
│           ├── differentiators.cljs
│           ├── methodology.cljs
│           ├── about.cljs
│           ├── target_audience.cljs
│           ├── brand_promise.cljs
│           ├── evidence.cljs
│           ├── cta.cljs
│           └── footer.cljs
├── shadow-cljs.edn         # Shadow-CLJS configuration
└── package.json            # Node dependencies
```

## Development

### Prerequisites

- Node.js and pnpm (or npm)
- Java JDK (for Clojure)

### Setup

```bash
pnpm install
```

### Run Development Server

```bash
pnpm dev
# or
shadow-cljs watch app
```

The app will be available at http://localhost:8080

### Build for Production

```bash
pnpm build
```

## Component Architecture

Each section of the page is now a separate, reusable ClojureScript component:

- **hero**: Hero section with main title and CTA
- **problem**: Problem statement section
- **solution**: Solution overview with metrics
- **services**: Service offerings cards
- **differentiators**: What sets Natalie apart
- **methodology**: Methodology explanation
- **about**: About Natalie section
- **target_audience**: Target audience definition
- **brand_promise**: Brand promise statement
- **evidence**: Research-backed evidence
- **cta**: Call-to-action section
- **footer**: Page footer

## Design Principles

Following Alan Kay and Doug Engelbart principles:
- Small, composable components (~200 lines max)
- Functional programming approach
- Declarative UI with Reagent/React

## Deployment

### Vercel

This project is configured for deployment on Vercel:

1. Push to GitHub:
```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/gmolinart/fashion_intelligence.git
git push -u origin main
```

2. Connect repository to Vercel:
   - Go to [Vercel Dashboard](https://vercel.com/dashboard)
   - Click "Import Project"
   - Select the GitHub repository
   - Vercel will auto-detect settings from `vercel.json`
   - Click "Deploy"

The build process will:
- Install dependencies
- Compile ClojureScript to JavaScript
- Deploy the `public` directory

