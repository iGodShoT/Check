using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using DiplomAPI.Models;

namespace DiplomAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrderContentsController : ControllerBase
    {
        private readonly FoodContext _context;

        public OrderContentsController(FoodContext context)
        {
            _context = context;
        }

        // GET: api/OrderContents
        [HttpGet]
        public async Task<ActionResult<IEnumerable<OrderContent>>> GetOrderContents()
        {
            return await _context.OrderContents.Include(x => x.Product).ToListAsync();
        }

        // GET: api/OrderContents/5
        [HttpGet("{id}")]
        public async Task<ActionResult<OrderContent>> GetOrderContent(int id)
        {
            var orderContent = await _context.OrderContents.FindAsync(id);

            if (orderContent == null)
            {
                return NotFound();
            }

            return orderContent;
        }

        [HttpGet("order/{orderID}")]
        public async Task<ActionResult<OrderContent>> GetOrderContentByOrderID(int orderID)
        {
            var orderContent = await _context.OrderContents.FindAsync(orderID);

            if (orderContent == null)
            {
                return NotFound();
            }

            return orderContent;
        }

        // PUT: api/OrderContents/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutOrderContent(int id, OrderContent orderContent)
        {
            if (id != orderContent.Id)
            {
                return BadRequest();
            }

            _context.Entry(orderContent).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!OrderContentExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/OrderContents
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<OrderContent>> PostOrderContent(OrderContent orderContent)
        {
            _context.OrderContents.Add(orderContent);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetOrderContent", new { id = orderContent.Id }, orderContent);
        }

        // DELETE: api/OrderContents/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteOrderContent(int id)
        {
            var orderContent = await _context.OrderContents.FindAsync(id);
            if (orderContent == null)
            {
                return NotFound();
            }

            _context.OrderContents.Remove(orderContent);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool OrderContentExists(int id)
        {
            return _context.OrderContents.Any(e => e.Id == id);
        }
    }
}
