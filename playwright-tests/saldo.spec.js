import {expect, test} from '@playwright/test';

test('Sidan går att nå', async ({page}) => {
    await page.goto('http://localhost:8080/saldo');
    await expect(page).toHaveTitle(/Saldo/);
});

test('Sidan laddas korrekt och visar saldot', async ({page}) => {
    await page.goto('http://localhost:8080/saldo');
    const saldoText = await page.locator('h1 span').textContent();
    expect(saldoText).toBe('5000');
});

test('Saldot är synligt på sidan', async ({page}) => {
    await page.goto('http://localhost:8080/saldo');
    const saldo = page.locator('h1 span');
    expect(await saldo.isVisible()).toBeTruthy();
});
