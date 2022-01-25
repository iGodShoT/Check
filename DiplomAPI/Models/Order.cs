using System;
using System.Collections.Generic;

#nullable disable

namespace DiplomAPI.Models
{
    public partial class Order
    {
        public Order()
        {
            OrderContents = new HashSet<OrderContent>();
        }

        public int Id { get; set; }
        public int ClientId { get; set; }
        public int EmployeeId { get; set; }
        public int StatusId { get; set; }
        public DateTime Date { get; set; }
        public decimal Total { get; set; }

        public virtual Client Client { get; set; }
        public virtual Employee Employee { get; set; }
        public virtual Status Status { get; set; }
        public virtual ICollection<OrderContent> OrderContents { get; set; }
    }
}
