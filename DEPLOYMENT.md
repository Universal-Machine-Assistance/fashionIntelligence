# Deployment Guide

## Deploy to Vercel

### Quick Start

1. **Connect to Vercel** (if not already connected):
   - Visit [https://vercel.com/dashboard](https://vercel.com/dashboard)
   - Click "Add New..." → "Project"
   - Import from your GitHub repository: `Universal-Machine-Assistance/fashionIntelligence`

2. **Configure Project** (Vercel will auto-detect settings from `vercel.json`):
   - **Framework Preset**: Other
   - **Build Command**: `npm run build`
   - **Output Directory**: `public`
   - **Install Command**: `npm install`

3. **Deploy**:
   - Click "Deploy"
   - Vercel will build and deploy your site automatically
   - You'll get a live URL like: `https://fashion-intelligence-xxx.vercel.app`

### Automatic Deployments

Once connected, Vercel will automatically:
- **Deploy on push to `main`**: Production deployments
- **Deploy preview branches**: Each PR gets a preview URL
- **Invalidate cache**: Automatically on new deployments

### Build Process

The Vercel build process:
1. Installs Node.js dependencies (React, Shadow-CLJS)
2. Installs Java JDK (for ClojureScript compilation)
3. Runs `shadow-cljs release app` to compile ClojureScript → JavaScript
4. Serves the `public/` directory as a static site

### Custom Domain

To add a custom domain:
1. Go to Project Settings → Domains
2. Add your domain (e.g., `fashionintelligence.com`)
3. Follow DNS configuration instructions
4. Vercel will automatically provision SSL certificates

### Environment Variables

This project doesn't require environment variables, but if needed:
1. Go to Project Settings → Environment Variables
2. Add key-value pairs
3. Redeploy for changes to take effect

### Troubleshooting

**Build fails with "Java not found"**:
- Vercel automatically provides Java, but if issues occur, add to `vercel.json`:
  ```json
  {
    "installCommand": "apt-get update && apt-get install -y default-jdk && npm install"
  }
  ```

**Build fails with ClojureScript errors**:
- Check the build logs in Vercel dashboard
- Ensure all dependencies are in `package.json`
- Test locally with `npm run build`

**Site loads but shows blank page**:
- Check browser console for JavaScript errors
- Verify `public/js/main.js` was generated
- Check that `index.html` correctly references `/js/main.js`

### Monitoring

- **Analytics**: Enable Vercel Analytics in Project Settings
- **Performance**: Use Vercel Speed Insights
- **Logs**: View function logs in Vercel Dashboard

### Local Testing

Before deploying, test the production build locally:

```bash
# Build for production
npm run build

# Serve the public directory
npx serve public

# Visit http://localhost:3000
```

## Alternative: Deploy to Netlify

If you prefer Netlify:

1. Create `netlify.toml`:
```toml
[build]
  command = "npm run build"
  publish = "public"

[[redirects]]
  from = "/*"
  to = "/index.html"
  status = 200
```

2. Connect repository to Netlify
3. Deploy

## Alternative: Deploy to GitHub Pages

For GitHub Pages:

1. Update `shadow-cljs.edn` to use the correct asset path:
```clojure
{:asset-path "/fashion_intelligence/js"}
```

2. Add GitHub Actions workflow (`.github/workflows/deploy.yml`):
```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches: [ main ]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-node@v2
        with:
          node-version: '18'
      - run: npm install
      - run: npm run build
      - uses: peaceiris/actions-gh-pages@v3
        with:
          github_token: ${{ secrets.GITHUB_TOKEN }}
          publish_dir: ./public
```

3. Enable GitHub Pages in repository settings

